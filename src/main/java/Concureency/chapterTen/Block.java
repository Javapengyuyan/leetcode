package concureency.chapterTen;

import concureency.common.Account;

import javax.naming.InsufficientResourcesException;

public class Block {
    public static final Object tieLock = new Object();

    public void transferMoney(final Account fromAcct,final Account toAcct,
                              final Integer amount) throws InsufficientResourcesException {
        class Helper{
            public void transfer() throws InsufficientResourcesException {
                if (fromAcct.getBalance().compareTo(amount) < 0 ){
                    throw new InsufficientResourcesException();
                }else {
                    fromAcct.debit(amount);
                    toAcct.credit(amount);
                }
            }
        }

        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);
        if (fromHash < toHash){
            synchronized (fromAcct){
                synchronized (toAcct){
                    new Helper().transfer();
                }
            }
        }else if (fromHash > toHash){
            synchronized (toAcct){
                synchronized (fromAcct){
                    new Helper().transfer();//???啥意思
                }
            }
        }else {
            synchronized (tieLock){//???啥意思
                synchronized (fromAcct){
                    synchronized (toAcct){
                        new Helper().transfer();
                    }
                }
            }
        }


    }

}
