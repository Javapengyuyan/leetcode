package com.middleware.zookeeper.case1;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author: long
 * @create: 2022-03-16 11:03
 * @Description
 **/

public class zkClient {

    //注意逗号之间不能有空格
    private String connecSting = "localhost:2181";
    private ZooKeeper zooKeeper;//ctrl+alt+f变量变为全局

    @Before
    public void init() throws Exception {

        int sesstionTimeout = 2000;//单位ms
        zooKeeper = new ZooKeeper(connecSting, sesstionTimeout, new Watcher() {
            /**
             * 创建监听器
             *
             * 监听节点变化
             *
             */
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    List<String> children = zooKeeper.getChildren("/", true);
                    /*for (String child : children) {
                        System.out.println(child);
                    }*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 创建节点
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        /**
         * 建立账号密码连接赋权
         */
        //zooKeeper.addAuthInfo("digest","V28q:NynI4JI3Rk54h0r8O5kMug=".getBytes());
        zooKeeper.addAuthInfo("digest","test:test".getBytes());
        zooKeeper.create("/test","ss.avi".getBytes(),
                //权限
                ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
    }


    /**
     * 查看监听节点
     */
    @Test
    public void getChildren(){
        try {
            List<String> children = zooKeeper.getChildren("/", true);
            for (String child : children) {
                System.out.println(child);
            }
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断节点是否存在
     */
    @Test
    public void testExit(){
        try {
            Stat exists = zooKeeper.exists("/sanguo", false);
            if (exists != null){
                System.out.println("存在");
            }
            //long czxid = exists.getCzxid();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
