package basic.thread.syn;

/**
 * @author: long
 * @create: 2022-02-14 21:46
 * @Description
 **/

public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(500, "结婚基金");
        Drawing drawing = new Drawing(account, 300, "男主");
        Drawing girlDrawing = new Drawing(account, 500, "女主");
        drawing.start();
        girlDrawing.start();

    }

}

//账户
class Account{

    int money;//金额
    String name;//卡名

    public Account(int money,String name) {
        this.money = money;
        this.name = name;
    }
}
//银行--模拟取钱
class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing( Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
        //this.name = name;
    }

    @Override
    public void run() {
        if (drawingMoney>account.money){
            System.out.println(Thread.currentThread().getName()+"卡内余额不足");
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //余额
        account.money = account.money-drawingMoney;
        //手里的钱
        nowMoney = nowMoney + drawingMoney;
        //System.out.println(account.name+"现在有"+nowMoney);
        System.out.println("结婚基金余额:"+account.money);
        //Thread.currentThread().getName();
        System.out.println(this.getName()+"手里的钱"+nowMoney);

    }
}
