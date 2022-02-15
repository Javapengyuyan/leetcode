package basic.thread.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: long
 * @create: 2022-02-15 09:53
 * @Description
 **/

public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread( ()->{
                list.add(Thread.currentThread().getName());
            } ).start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}
