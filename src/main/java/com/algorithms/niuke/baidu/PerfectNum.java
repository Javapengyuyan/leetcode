package com.algorithms.niuke.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0){
            return;
        }
        List<Long> list = new ArrayList<>();
        for (int i=0;i<num;i++){
            list.add(Long.valueOf(sc.nextLine()));
        }
        for (int i=0 ;i<list.size();i++){
            print(list.get(i));
        }

    }

    static public void print(long n){
        String num = String.valueOf(n);
        char[] chars = num.toCharArray();
        char y = '3';

        for (int i=0;i<chars.length;i++){
            int x = chars[i] - y;
            if ( x>0 ){
                chars[i] = '3';
            }
        }
        System.out.println(String.valueOf(chars));
    }

}
