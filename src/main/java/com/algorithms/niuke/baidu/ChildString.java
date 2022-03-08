package com.algorithms.niuke.baidu;

import java.util.HashSet;
import java.util.Scanner;

public class ChildString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0){
            return;
        }
        int childNum = sc.nextInt();
        String string = sc.nextLine();
        char[] chars = string.toCharArray();
        HashSet<String> set = new HashSet<String>();
        for (int i=0 ;i<string.length();i++){
            set.add(String.valueOf(chars[i]));
        }
        int total = set.size();
        if (total < childNum){
            System.out.println(0);
        }else if (total == childNum){
            System.out.println(1);
        }else {
            System.out.println(total- childNum);
        }
    }

}
