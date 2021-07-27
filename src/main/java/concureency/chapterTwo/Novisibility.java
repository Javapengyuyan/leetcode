package concureency.chapterTwo;

public class Novisibility {

    private  static  boolean ready;
    private static  int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run(){
            while ( !ready ){
                Thread.yield();
                System.out.println(number);
            }

        }
    }

    public static void main(String[] args) {
        new ReaderThread().run();
        number = 42;
        ready = true;

    }



}
