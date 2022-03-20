package com.middleware.zookeeper.case2;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: long
 * @create: 2022-03-16 10:58
 * @Description
 **/

public class DistributedLock {

    final private ZooKeeper zk;
    final private String connecSting = "localhost:2181";
    final private String path  = "/locks";

    private CountDownLatch connectLatch = new CountDownLatch(1);
    private String waitPath;
    private CountDownLatch waitLatch = new CountDownLatch(1);
    private String currentNode;

    public DistributedLock() throws Exception {

        //1、建立连接
        zk = new ZooKeeper(connecSting, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                /**
                 * 判断是否连接上zk，连接上则释放await连接门闩
                 */
                if ( watchedEvent.getState() == Event.KeeperState.SaslAuthenticated ){
                    connectLatch.countDown();
                }
                /**
                 * 判断是删除操作，而且是删除前一个节点，则释放锁
                 */
                if ( watchedEvent.getType() == Event.EventType.NodeDeleted &&
                        watchedEvent.getPath().equals(waitPath)){
                    waitLatch.countDown();
                }

            }
        });
        /**
         * 这个目的：等待zk建立连接后，程序才会继续走，保证程序健壮性
         */
        //这个好像判断不了？？
        //connectLatch.await();

        //2、判断根节点是否存在，否-创建
        Stat exists = zk.exists(path, false);
        if (exists == null){
            zk.create("/locks","locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);
        }

        //3、创建节点，对zk加锁
        zkLock("");

        //4、业务代码，完成后释放锁
        zkUnlock("");
    }

    public void zkUnlock(String threadName) {
        try {
            zk.delete(currentNode,-1);
            System.out.println(threadName+"删除的的节点:"+currentNode);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }


    public void zkLock(String threadName) throws KeeperException, InterruptedException {
        currentNode = zk.create("/locks" + "/seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(threadName+"创建的节点:"+currentNode);
        List<String> children = zk.getChildren("/locks", true);
        if (children.size() == 1){
            return;
        }else {
            Collections.sort(children);
            //获取当前节点名称seq-0000001
            String thisNode = currentNode.substring((path + "/").length());
            int index = children.indexOf(thisNode);
            //监听是否为最小节点，获取锁
            if (index==-1){
                //异常
                System.out.println("异常");
                return;
            }else if (index == 0){
                //表示第一个
                return;
            }else {
                //非第一个,获取前一个节点路径
                waitPath = path+"/"+children.get(index - 1);
                zk.getData(waitPath,true,new Stat());

                //等待监听，等待前一个节点完成
                waitLatch.await();
                return;
            }
        }
    }

}
