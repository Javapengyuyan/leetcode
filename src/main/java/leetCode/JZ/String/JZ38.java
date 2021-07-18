package leetCode.JZ.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class JZ38 {

    //全排列、DFS
    /*List<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        LinkedList<Integer> track = new LinkedList<>();
        char[] chars = s.toCharArray();
        backtrack(0,chars);
        String[] strings = (String[])res.toArray();
        return  strings;
    }

    *//**
     * 当作决策树
     * 回溯也是递归。参数：路径，决策列表
     * @param x
     * @param chars
     *//*
    public void backtrack(int x,char[] chars){
        if (x == chars.length){
            res.add(chars.toString());
            return;
        }
        for (int i=0;i<x;i++){
            chars[i]= chars[x];
            backtrack(x,chars);
            chars[x]=chars[i];

        }


    }*/

    static List<String> res = new LinkedList<>();
    static char[] c;
    public static String[] permutation(String s){
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    static void dfs(int x){
        if (x == c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i=x;i<c.length;i++){
            if (set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }

    }

    static void swap(int a,int b){
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        String s = "abc";
        String[] strings = permutation(s);
        System.out.println(strings);

    }

}
