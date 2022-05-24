package com.algorithms.leetCode.Hot100.StackTest;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: long
 * @create: 2022-03-29 22:40
 * @Description 注意char类型初始化只能为一个字符
 * stack有peek()方法查看最上面值
 *
 **/

public class hot20 {
    public static void main(String[] args) {
        String s = "(){}}{";
        boolean valid = isValid(s);
        boolean valid2 = isv(s);
        System.out.println(valid);
        System.out.println(valid2);

    }

    static public boolean isv(String s){
        if (s.length()<2 || s.length()%2 != 0 ){
            return false;
        }
        HashMap<Character,Character> hashMap = new HashMap<>(5);
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');
        //这个也可以
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if ( hashMap.containsKey( charAt )){
                if (!stack.isEmpty() && stack.peek() == hashMap.get(charAt)){
                    stack.pop();
                }
                return false;
            }else {
                stack.push(charAt);
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 写的也太长吧，还写的那么慢
     * @param s
     * @return
     */
    static public boolean isValid(String s) {
        if (s.length()<2 || s.length()%2 != 0 ){
            return false;
        }
        char[] chars = s.toCharArray();
        if (chars[0] == ')' || chars[0] == '}' ||chars[0] == ']'){
            return false;
        }
        Stack<Character> stack = new Stack();
        char top = '0';
        for (int i = 0; i < chars.length; i++) {
            char pop = chars[i];
            if (pop == '(' || pop == '{' || pop == '[') {
                stack.push(pop);
                top = pop;
            } else{
                if (!stack.isEmpty()){
                    top = stack.peek();
                }
                if (pop == ')' && top == '(') {
                    stack.pop();
                    top='0';
                } else if (pop == '}' && top == '{') {
                    stack.pop();
                    top='0';
                } else if (pop == ']' && top == '[') {
                    stack.pop();
                    top='0';
                }else {
                    stack.push(pop);
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;

    }

}

