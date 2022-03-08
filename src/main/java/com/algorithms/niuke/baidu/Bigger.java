package com.algorithms.niuke.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bigger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        if (length == 0){
            return;
        }
        int multiple = sc.nextInt();
        Scanner in = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        for (int i=0;i<length;i++){
            String line = in.nextLine();
            String[] strings = line.trim().split(" ");
            if (strings.length != length){
                return;
            }
            list.add(strings);
        }
        for (int i=0 ;i<list.size();i++){
            print(list.get(i),multiple);
        }

    }

    static public void print(String[] strings,int n){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<strings.length;i++){
            for (int j=0;j<n;j++){
                stringBuffer.append(strings[i]);
                stringBuffer.append(" ");
            }
        }
        for (int j=0;j<n;j++){
            System.out.println(stringBuffer.toString());
        }

    }

}
