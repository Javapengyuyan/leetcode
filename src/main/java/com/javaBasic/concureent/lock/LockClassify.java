package com.javaBasic.concureent.lock;

/**
 * @author: long
 * @create: 2022-04-13 14:38
 * @Description
 **/

public class LockClassify {

    static Integer total = 0;
    public static void main(String[] args) {

        //乐观锁、悲观锁  https://www.jb51.net/article/215612.htm
        /**
         * 乐观：读取数据时，认为别的线程不会修改。
         *      写数据时，判断当前 与期望值是否相同，如果相同则进行更新CAS
         * 悲观：每次读写都认为其它线程会修改，
         *      每次读写都加锁。synchronized、vector、hashtable
         */

        //自旋锁
        /**
         * 为了让线程等待，我们只须让线程执行一个忙循环
         *  优点：避免了线程切换的开销，挂起线程和恢复线程的操作都需要转入内核态中完成，
         *       这些操作给Java虚拟机的并发性能带来了很大的压力
         * 缺点：占用处理器的时间，如果占用的时间很长，消耗处理器资源，带来性能的浪费。
         *
         * jvm调优：
         *     -XX:PreBlockSpin 设置固定失败次数
         *     自适应自旋 前一次在同一个锁上的自旋时间及锁的拥有者的状态来决定的，通过系统监控进行调整
         */

        //重入锁、非重入
        /**
         * 应用
         *     synchronized、Reentrantlock、Lock
         * 思想：
         *      任意线程在获取到锁之后能够再次获取该锁而不会被锁所阻塞
         * 实现
         *      通过组合自定义同步器来实现锁的获取与释放
         *      获取锁：识别获取锁的线程是否为当前占据锁的线程 ，如果是，则再次成功获，。获取锁后，进行计数自增
         *      释放锁：释放锁时，进行计数自减
         * 优点：
         *      避免死锁
         * 缺点
         *     他线程想要读写这个数据时，会被这个线程block，直到这个线程释放锁然后其他线程获取到锁
         *
         */
        //公平锁、非公平
        /**
         * 公平锁：Reentrantlock(true)
         * 思想
         *     多个线程按照申请锁的顺序来获取锁
         * 实现
         *     在并发环境中，每个线程会先查看此锁维护的等待队列，如果当前等待队列为空，则占有锁，如果等待队列不为空，则加入到等待队列的末尾，
         *     按照FIFO的原则从 队列中拿到线程，然后占有锁
         *
         * 非公平锁：synchronized、reentrantlock(false)
         * 思想
         *     线程尝试获取锁，如果获取不到，则再采用公平锁的方式
         * 实现
         *     多个线程获取锁的顺序，不是按照先到先得的顺序，有可能后申请锁的线程比先申请的线程优先获取锁
         *
         */

        //共享锁、独锁
        /**
         * 共享锁：ReentrantReadWriteLock中读锁
         * 思想
         *     可以有多个线程获取读锁，以共享的方式持有锁
         *
         * 独锁：synchronized、vector、hashtable、ReentrantReadWriteLock中写锁
         * 思想
         *     是一种思想： 只能有一个线程获取锁，以独占的方式持有锁
         *
         */
        //轻量级、重量锁
        /**
         * 重量级锁：synchronized
         * 思想
         *     synchronized是通过对象内部的一个叫做监视器锁（monitor）来实现的，监视器锁本身依赖底层的操作系统的 Mutex Lock来实现。
         * 缺点
         *     操作系统实现线程的切换需要从用户态切换到核心态，成本非常高。这种依赖于操作系统 Mutex Lock来实现的锁称为重量级锁。
         * 改进
         *     为了优化synchonized，引入了轻量级锁，偏向锁。
         *
         * 轻量级：
         * 应用
         *     锁优化技术
         * 思想
         *     轻量级锁是在无竞争的情况下使用CAS操作去消除同步使用的互斥量。
         *     轻量级是相对于使用操作系统互斥量来实现的重量级锁而言的。
         *     轻量级锁在没有多线程竞争的前提下，减少传统的重量级锁使用操作系统互斥量产生的性能消耗。
         *     如果出现两条以上的线程争用同一个锁的情况，那轻量级锁将不会有效，必须膨胀为重量级锁。
         * 优点
         *     如果没有竞争，通过CAS操作成功避免了使用互斥量的开销
         * 缺点
         *     如果存在竞争，除了互斥量本身的开销外，还额外产生了CAS操作的开销，因此在有竞争的情况下，轻量级锁比传统的重量级锁更慢
         *
         */




    }

}
