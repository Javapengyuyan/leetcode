package Test;

import java.util.Calendar;

public class Time {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year,11,31,23,59,59);
        Long yearLastTime = calendar.getTimeInMillis();
        Long sysTimeMills = System.currentTimeMillis();
        System.out.println(yearLastTime-sysTimeMills);
        int a = (int) (yearLastTime-sysTimeMills)/1000;
        System.out.println(a);
        //int t1= Math.toIntExact(yearLastTime);
        //int t2 = Math.toIntExact(sysTimeMills);
        //System.out.println(t1-t2);
        int t1= yearLastTime.intValue();
        int t2 = sysTimeMills.intValue();
        System.out.println(t1-t2);
        Integer integer =  (int)((yearLastTime-sysTimeMills)/1000);
        System.out.println(integer);


    }
}
