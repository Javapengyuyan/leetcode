package com.javaBasic.javaSE;

import java.lang.ref.*;
import java.util.HashSet;

/**
 * @author: long
 * @create: 2022-04-19 16:20
 * @Description 强引用、软引用、弱引用、虚引用
 **/

public class ReferenceTest {

    public void test() {
        /**
         * 1、强引用
         * 生活中必不可少东西，内存不足抛出异常也不会回收。
         *
         */
        String s1 = new String("name");
        /**
         * 2、软引用
         * 可有可无东西，内存空间不足就会回收这些对象内存。
         * 应用：内存敏感高速缓存，可以和一个引用队列（ReferenceQueue）联合使用
         *
         */
        String s2= new String("age");
        SoftReference softReference = new SoftReference<String>(s2);
        /**
         * 3、弱引用
         * 可有可无，弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。
         *
         */
        WeakReference weakReference = new WeakReference(s1);

        /**
         * 4、虚引用 PhantomReference
         * 虚引用并不会决定对象的生命周期。如果一个对象仅持有虚引用，那么它就和没有任何引用一样，
         * 在任何时候都可能被垃圾回收。
         *
         */
        String s3 = new String("xu");
        ReferenceQueue<Object> rq = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(s3,rq);
    }

    public void method1(){
        //创建一个强引用
        String str = new String("hello");
        //创建引用队列;为范型标记，表明队列中存放String对象的引用
        ReferenceQueue<String> rq = new ReferenceQueue();
        //创建一个弱引用，它引用"hello"对象，并且与rq引用队列关联//为范型标记，表明WeakReference会弱引用String对象
        WeakReference<String> wf = new WeakReference(str, rq);
    }

    public void method2(){
        String str = new String("hello"); //①;
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        WeakReference<String> wf = new WeakReference(str, rq);
        str = null;//④取消"hello"对象的强引用String str1=wf.get(); //⑤假如"hello"对象没有被回收，str1引用"hello"对象
        //假如"hello"对象没有被回收，rq.poll()返回null
        String str1 = wf.get();
        Reference<? extends String> poll = rq.poll();

    }

    public void method3(){
        String str = new String("hello"); //①;
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        WeakReference<String> wf = new WeakReference(str, rq);
        str = null;
        //两次催促垃圾回收器工作，提高"hello"对象被回收的可能性
        System.gc();
        System.gc();
        String str1 = wf.get();//⑦ 假如"hello"对象被回收，str1为null
        Reference<? extends String> poll = rq.poll();
    }

    /**
     * method4：
     * 在以下代码References类中，依次创建了10个软引用、10个弱引用和10个虚引用，
     * 它们各自引用一个Grocery对象。从程序运 行时的打印结果可以看出，虚引用形同虚设，
     * 它所引用的对象随时可能被垃圾回收，具有弱引用的对象拥有稍微长的生命周期，
     * 当垃圾回收器执行回收操作时，有可能被垃圾回收，具有软引用的对象拥有较长的生命周期，
     * 但在Java虚拟机认为内存不足的情况下，也会被垃圾回收。
     */
    static ReferenceQueue rq = new ReferenceQueue();
    static public void checkQueue(){
        Reference inq = rq.poll();
        if (inq != null){
            System.out.println("in queue: "+inq+":"+inq.get());
        }
    }

    public static void main(String[] args) {
        final int size = 10;
        //创建10个Grocery对象以及10个软引用
        HashSet sa = new HashSet<>();
        for (int i = 0; i < size; i++) {
            SoftReference ref = new SoftReference(new Grocery("soft" + i), rq);
            System.out.println("创建软引用："+ref.get());
            sa.add(ref);
        }
        System.gc();
        checkQueue();
        System.out.println("-------------------");
        //创建10个Grocery对象以及10个弱引用
        HashSet wa = new HashSet();
        for (int i = 0; i < size; i++) {
            WeakReference ref = new WeakReference(new Grocery("weak" + i), rq);
            System.out.println("创建弱引用："+ref.get());
            wa.add(ref);
        }
        System.gc();
        checkQueue();
        System.out.println("-------------------");
        //创建10个Grocery对象以及10个虚引用
        HashSet pa = new HashSet();
        for (int i = 0; i < size; i++) {
            PhantomReference ref = new PhantomReference(new Grocery("Phantom" + i), rq);
            System.out.println("创建虚引用"+ref.get());
            pa.add(ref);
        }
        System.gc();
        checkQueue();

    }

}

class Grocery{
    private static final int SIZE = 10000;
    // 属性d使得每个Grocery对象占用较多内存，有80K左右
    private double[] d = new double[SIZE];
    private String id;

    public Grocery(String id) {
        this.id = id;
    }

    public String toString() {
        return id;
    }

    public void finalize() {
        System.out.println("Finalizing:"+id);
    }
}
