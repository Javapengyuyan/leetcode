package algorithm.回溯;

import java.util.Scanner;

public class CheckWord {

    /**
     * 回溯算法：1、基本框架结构（跳出条件，递归循环，回退）
     * 类似二叉树遍历
     *
     *
     */

    public static void main(String[] args) {
        //给定二位数组
        String[][] root = new String[][]{{"s","t"},{"c","f"}};
        int x = root[0].length;
        int y = root.length;
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String[] strings = word.split("");
        int z = 0;
        //创建相同标记数组
        int[][] flag = createInts(root);

        for (int i=0;i<x-1;i++){
            for (int j=0;j<y-1;j++){
                if (root[i][j].equals(strings[z])){
                    checkString(root,i,j,strings,z,flag);
                }
                flag[i][j]=0;
            }
        }


    }

    public static Boolean checkString(String[][] root,int x,int y,String[] strings,int z,int[][] flag){
        if (z == strings.length-1){
            return true;
        }


        return false;
    }


    public static int[][] createInts(String[][] root){
        int row = root[0].length;
        int line = root.length;
        int[][] ints = new int[][]{};
        for (int i=0;i<row-1;i++){
            for (int j=0;j<line-1;j++){
                ints[i][j] = 0;
            }
        }
        return ints;
    }







}
