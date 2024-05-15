package com.middleware.zookeeper.case1;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: long
 * @create: 2022-03-18 15:33
 * @Description
 **/

public class DistributeClient {

    private ZooKeeper zk;
    private String connecSting = "localhost:2181";
    private String path  = "/servers";

    public static void main(String[] args) {
        /*ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        System.out.println("==========="+arrayList);*/

        DistributeClient client = new DistributeClient();
        try {
            //1、连接
            client.getConnect();
            //2、监听节点
            client.getServerList();
            //3、业务逻辑
            client.business();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void business() throws InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
    }

    private void getServerList() throws KeeperException, InterruptedException {
        //是否使用监听器
        List<String> children = zk.getChildren(path, true);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String child : children) {
            byte[] data = zk.getData(path + "/" + child, false, null);
            /**
             * 这里不能用toString转byte，需要new一个String
             */
            arrayList.add(new String(data));
        }
        System.out.println("=============="+arrayList);
    }

    private void getConnect() throws Exception {
        zk = new ZooKeeper(connecSting, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                /**
                 * 监听只触发一次，如何保证一直监听？
                 * 监听完后再触发一次，一直套娃
                 */
                try {
                    getServerList();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
