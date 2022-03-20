package com.middleware.zookeeper.case2;

import org.apache.zookeeper.KeeperException;

/**
 * @author: long
 * @create: 2022-03-20 12:35
 * @Description
 **/

public class DistributedLockTest {

    public static void main(String[] args) throws Exception {
        final DistributedLock lock1 = new DistributedLock();
        final DistributedLock lock2 = new DistributedLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.zkLock("线程一");
                    System.out.println("线程1获取锁");
                    Thread.sleep(5*1000);
                    lock1.zkUnlock("线程一");
                    System.out.println("线程1释放锁");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.zkLock("线程二");
                    System.out.println("线程2获取锁");
                    Thread.sleep(5*1000);
                    lock2.zkUnlock("线程二");
                    System.out.println("线程2释放锁");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }

}
