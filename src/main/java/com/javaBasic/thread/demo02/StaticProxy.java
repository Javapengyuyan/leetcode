package com.javaBasic.thread.demo02;

/**
 * @author: long
 * @create: 2022-02-12 19:52
 * @Description 静态代理模式
 *
 * 好处：代理能做很多其它的事情，具体实现类专注于自己的事情
 **/

public class StaticProxy {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("爱你哟");
            }
        }).start();
        //1、结婚 2、婚庆公司代理3、自己实现
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
        //对比
        new Thread( ()-> System.out.println("爱老虎油too") ).start();
        new WeddingCompany(new You()).HappyMarry();
        /**
         * 总结:Thread类和静态代理
         * lambda线程的表达式就是静态代理，代理的Runnable然后自己实现了start方法
         */
    }

}

class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("结婚");
    }
}

class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后补全金额");
    }

    private void before() {
        System.out.println("结婚前交定金");
    }
}

interface Marry{

    void HappyMarry();
}
