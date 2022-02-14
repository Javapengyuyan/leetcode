package basic.thread.state;

import java.util.Date;

/**
 * @author: long
 * @create: 2022-02-13 19:54
 * @Description   倒计时
 *
 * 每个线程都有一把锁，sleep不会释放锁。
 **/

public class TestSleep {

    static Integer times = 10;

    public static void main(String[] args) throws Exception {
        tenLast();
        while (true){
            Date date = new Date(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
                System.out.println(date);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //模拟倒计时
    static public void tenLast() throws Exception {
        while (true){
            if (times<0){
                break;
            }
            System.out.println(times);
            Thread.sleep(1000);
            times--;
        }

    }


}
