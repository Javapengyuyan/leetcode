package Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Hui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strValue=sc.nextLine();
        int number = Integer.parseInt(strValue);
        Deque deque = new LinkedList();
        while (number != 0) {
            int last = number % 10;
            deque.push(last);
            number /= 10;
        }
        Integer total = 0;
        if (deque.size() == 1){
            System.out.println(total);
            return;
        }
        while (deque.size() > 1){
            Integer first = (Integer) deque.getFirst();
            deque.removeFirst();
            Integer last = (Integer) deque.getLast();
            deque.removeLast();
            if (first != last){
                total = total + switchNum(first);
                total = total + switchNum(last);
            }
        }
        if (deque.size() != 0){
            total = total + switchNum((Integer) deque.getFirst());
        }
        System.out.println(total);

    }

    public static Integer switchNum(Integer num){
        Integer sum = 0;
        switch (num){
            case 1 :
                sum = 100;
                break;
            case 2 :
                sum = 200;
                break;
            case 3 :
                sum = 200;
                break;
            case 4 :
                sum = 220;
                break;
        }
        return sum;
    }


}
