package com.algorithms.niuke.meiTuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class jzyx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] param = firstLine.split("\\s+");
        List q = new ArrayList();
        for (int i=0;i<Integer.valueOf(param[3]);i++){
            String line = scanner.nextLine();
            q.add(line);
        }



    }
}
