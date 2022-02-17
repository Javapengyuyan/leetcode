package basic.thread.lock;

/**
 * @author: long
 * @create: 2022-02-15 14:05
 * @Description
 *
 * 死锁条件：1、互斥：一个资源只允许一个进程使用。
 *         2、保持：请求阻塞时，进程对已获得资源不自释放。
 *         3、不剥夺：进程在使用完成前，不能被强行剥夺资源。
 *         4、循环：若干进程形成循环等待资源关系
 *
 **/

public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup = new Makeup("白雪公主",0);
        Makeup girl = new Makeup("灰姑娘",1);
        makeup.start();
        girl.start();

    }
}

class Lipstick{

}
class Mirrmor{

}

class Makeup extends Thread {
    static Lipstick lipstick = new Lipstick();
    static Mirrmor mirrmor = new Mirrmor();

    private String name;
    private int type;

    public Makeup(String name, int type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            makeUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void makeUp() throws Exception {
        if (0 == type){
            synchronized(lipstick){
                System.out.println(name+"获得口红锁");
                Thread.sleep(1000);

            }
            /**
             * 将锁住的对象分开后不会死锁
             */
            synchronized (mirrmor){
                System.out.println(name+"获得镜子锁");
            }
        }else {
            synchronized (mirrmor){
                System.out.println(name+"获得镜子锁");
                Thread.sleep(1000);

            }
            synchronized (lipstick){
                System.out.println(name+"获得口红锁");
            }
        }
    }


}