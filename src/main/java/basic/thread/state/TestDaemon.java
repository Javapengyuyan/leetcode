package basic.thread.state;

/**
 * @author: long
 * @create: 2022-02-14 11:13
 * @Description
 *
 * 1、线程分为：用户线程、守护线程两种。
 * 2、测试线程设置为守护线程时候，是否会影响关闭
 *    虚拟机必须确保用户线程执行完毕，不用保证守护线程执行完毕
 * 3、
 *
 **/

public class TestDaemon {

    public static void main(String[] args) {
        You you = new You();
        God god = new God();
        Thread godThread = new Thread(god);
        godThread.setDaemon(true);
        godThread.start();
        Thread thread = new Thread(you);
        thread.start();

    }

}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("老天保佑着你");
        }
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("活了"+i+"岁!");
            if (i == 100){
                System.out.println("世界和平gg");
            }
        }
    }
}