package com.algorithms.niuke.剑指offer;

import java.util.Scanner;

public class jz2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s.replaceAll(" ","xxx"));
        StringBuffer stringBuffer = new StringBuffer(s);
        System.out.println(replaceSpace(stringBuffer));
    }

    public static String replaceSpace(StringBuffer str) {
        String s = str.toString();
        s = s.replaceAll("\\s","%20");
        return s;
    }
}
