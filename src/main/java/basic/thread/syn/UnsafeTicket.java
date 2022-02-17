package basic.thread.syn;

/**
 * @author: long
 * @create: 2022-02-14 17:37
 * @Description 不安全的买票
 *
 *
 **/

public class UnsafeTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"牛逼的你").start();
        new Thread(buyTicket,"倒霉的我").start();
        new Thread(buyTicket,"无耻的黄牛").start();

    }
}


class BuyTicket implements Runnable{
    private int ticketNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag){
            buy();
        }
    }

    private void buy(){
        //是否有票
        if (ticketNum<=0){
            flag = false;
            return;
        }
        //模拟延迟
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNum--);
    }

}