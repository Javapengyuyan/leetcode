package basic.javaSE.threadRunnable;

/**
 * @author: long
 * @create: 2021-12-29 14:26
 * @Description
 **/

public class Test01 {

    public static Boolean flag = false;
    public static int num = 0;

    public static void main(String[] args) {


    }

    public class Man {
        public synchronized void getRunnable1(){
            for (int i = 0; i < 20; i++) {
                while (flag){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产出"+(++num)+"个");
                flag = true;
                notify();
            }
        }

        public void getRunnable2(){


        }

    }


}

