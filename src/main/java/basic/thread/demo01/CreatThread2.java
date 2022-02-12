package basic.thread.demo01;

/**
 * @author: long
 * @create: 2022-02-10 22:35
 * @Description
 **/

public class CreatThread2 implements Runnable {
    @Override
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println("我在看代码!!!"+i);
        }
    }

    public static void main(String[] args) {

        CreatThread2 creatThread = new CreatThread2();
        new Thread(creatThread).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程！！！"+i);
        }

    }
}
