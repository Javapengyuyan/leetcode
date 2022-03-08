package com.algorithms.niuke.byteDance;

import java.util.ArrayDeque;
import java.util.Scanner;

public class 检测投稿错误 {
    public static void  main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String[] strings = inputString.trim().split("");
        //List<String> byteStrings = new ArrayList<>();
        ArrayDeque<String> queue = new ArrayDeque();
        Boolean sameByte = false;//前面是否有相同的字节
        for (String byteString: strings){
            String queueLast = queue.peekLast();
            if (byteString.equals(queueLast)){
                if (sameByte){
                    continue;
                }else {
                    sameByte = true;
                    queue.addLast(byteString);
                }
            }else {
                if (sameByte){
                    String last = queue.pollLast();
                    String secondLast = queue.pollLast();
                    if (!last.equals(secondLast)){
                        sameByte = false;
                    }
                    queue.addLast(secondLast);
                    queue.addLast(last);
                }
                queue.addLast(byteString);
            }

        }
        for (String q : queue){
            System.out.print(q);
        }

    }

}
