package leetCode.JZ.Tree;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class JZ37 implements Runnable{
    public static void main(String[] args) {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                //第六章--执行任务。
            }
        };

    }

    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;


    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled){
            p=p.nextProbablePrime();
            synchronized(this){
                primes.add(p);
            }
        }

    }
    public void cancel(){
        cancelled = true;
    }
    public synchronized List<BigInteger> getPrimes(){
        return new ArrayList<>(primes);
    }



}
