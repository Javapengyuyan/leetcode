package TuLing.Second;

import java.util.concurrent.locks.ReentrantLock;

public class T0_MultiAndUnsafe {
    private static Integer total = 0;
    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        for (int i=0;i<100;i++){
            new Thread(()->{
                for (int j=0;j<100;j++){
                    total++;
                }

            }).start();
        }

    }

}
