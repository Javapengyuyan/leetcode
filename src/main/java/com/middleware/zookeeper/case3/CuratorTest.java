package com.middleware.zookeeper.case3;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;

/**
 * @author: long
 * @create: 2022-03-20 14:08
 * @Description curator框架实现分布式锁
 *
 * 备注：4.0.1版本太高，会导致与zk不匹配报错。因此pom用2.8.0
 **/

public class CuratorTest {

    public static void main(String[] args) {
        //创建分布式锁1
        InterProcessMutex lock1 = new InterProcessMutex(getCuratorFramework(),"/locks");
        //创建分布式锁2
        InterProcessMutex lock2 = new InterProcessMutex(getCuratorFramework(),"/locks");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.acquire();
                    System.out.println("线程1获取锁");
                    /**
                     * 证明是可重入锁
                     */
                    lock1.acquire();
                    System.out.println("线程1再次获取到锁");
                    Thread.sleep(5000);
                    lock1.release();
                    System.out.println("线程1释放锁--");
                    lock1.release();
                    System.out.println("线程1再次释放锁--");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.acquire();
                    System.out.println("线程2获取锁");
                    /**
                     * 证明是可重入锁
                     */
                    lock2.acquire();
                    System.out.println("线程2再次获取到锁");
                    Thread.sleep(5000);
                    lock2.release();
                    System.out.println("线程2释放锁--");
                    lock2.release();
                    System.out.println("线程2再次释放锁--");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }

    private static CuratorFramework getCuratorFramework() {
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(3000, 3);

        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
                .connectionTimeoutMs(2000)
                .sessionTimeoutMs(200)
                .retryPolicy(retry).build();
        //启动客户端
        client.start();
        System.out.println("zk 启动成功！");
        return client;
    }

}
