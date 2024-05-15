package concurrent.concurrentArt.one;

/**
 * @author: long
 * @create: 2023-02-28 17:15
 * @Description
 **/

public class SyncDemo {

    public void syc(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Integer i = 0;
        synchronized (i){
            for (; i < 100; i++) {

            }
        }

    }

}
