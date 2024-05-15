package concurrent.TuLing.Second;

public class Jmm04 {

    private volatile static int counter = 0;

    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            Thread thread = new Thread(()->{
                counter++;
            });
            thread.start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }

}
