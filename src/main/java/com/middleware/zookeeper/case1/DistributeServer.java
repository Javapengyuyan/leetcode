package com.middleware.zookeeper.case1;

import org.apache.zookeeper.*;

/**
 * @author: long
 * @create: 2022-03-17 18:49
 * @Description 服务动态上下线
 **/

public class DistributeServer {

    private ZooKeeper zk;
    private String connecSting = "localhost:2181";

    public static void main(String[] args) {
        DistributeServer server = new DistributeServer();
        try {
            //1、获取zk连接
            server.getConnect();
            //2、注册服务到zk集群
            server.regist(args[0]);
            //3、启动业务逻辑
            server.business();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void business() throws InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
    }

    private void regist(String hostName){
        //注册临时有序节点，才能监听以及查看顺序
        try {
            zk.create("/servers/",hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(hostName + " is online");

        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    private void getConnect() throws Exception {
        int sesstionTimeout = 2000;//单位ms
        zk = new ZooKeeper(connecSting, sesstionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });

    }


}
