package com.algorithms.niuke.meiTuan;

import java.util.Scanner;

public class dxx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int upperSize = 0;
        for (int i=0;i<firstLine.length();i++){
            if(Character.isUpperCase(firstLine.charAt(i))){
                upperSize++;
            }
        }
        int num = Math.abs(firstLine.length()-2*upperSize)/2;
        System.out.println(num);
    }

}
