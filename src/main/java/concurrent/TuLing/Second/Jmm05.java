package concurrent.TuLing.Second;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Jmm05 {

    /**
     * 可能出现指令重排，测试代码
     */
    private static int x = 0,y=0;
    private static int a=0,b=0;

    public static void main(String[] args) throws InterruptedException {
        int i=0;
        for (;;){
            i++;
            x=0;y=0;
            a=0;b=0;
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    shortWait(1000);

                    a=1;
                    x = b;
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b=1;
                    y=a;
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            String result ="第" + i +"次("+x+","+y+")";
            if (x == 0 && y==0){
                System.out.println(result);
                break;
            }else {
                log.info(result);
            }

        }


    }

    public static void shortWait(Integer time){
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        }while (start + time >= end);

    }




}
