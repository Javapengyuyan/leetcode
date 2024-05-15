package com.personal.leetcode.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Robbort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        while (sc.hasNext()) {
            String input = sc.next();
            stringList.add(input);
        }

        List<Integer> rList = new ArrayList();
        List<Integer> lList = new ArrayList();
        for (int i=1;i<stringList.size();i++){
            String s = stringList.get(i);
            String[] strings = s.split(" ");
            Integer location = Integer.valueOf(strings[0]);
            String c = strings[1];
            if ("R".equals(c)){
                rList.add(location);
            }else {
                lList.add(location);
            }
        }

        for (int i=0;i<rList.size();i++){
            int num = Integer.MAX_VALUE;
            for (int j=0;j<lList.size();j++){
                if (rList.get(i)>lList.get(j)){
                    continue;
                }
                int add = rList.get(i)+lList.get(j);
                if (add%2 == 0){
                    int time = (lList.get(j)-rList.get(i))/2;
                    num = Math.min(num,time);
                }
            }
        }


    }
}
