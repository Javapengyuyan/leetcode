package concurrent.TuLing.Second;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Thread02 {

    private static boolean initflag = false;
    private volatile static int counter = 0;

    public static void refresh(){
        log.info("refer data ....");
        initflag = true;
        log.info("refer data success....");
    }

    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            while (! initflag){
                counter++;
            }
            log.info("线程:"+Thread.currentThread().getName()+"嗅到initflag改变");

        },"threadA");
        thread.start();

        try {
            thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread threadB = new Thread(()->{
            refresh();
        },"threadB");
        threadB.start();
        try {
            threadB.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
