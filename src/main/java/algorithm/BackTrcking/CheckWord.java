package algorithm.BackTrcking;

import java.util.Scanner;

public class CheckWord {

    /**
     * 回溯算法：1、基本框架结构（跳出条件，递归循环，回退）
     * 类似二叉树遍历,遍历一棵状态数，只不过状态树是隐形动态生成。
     * 回溯不同于递归算法
     *
     * 回溯框架结构：
     * 开始节点
     * 判定返回条件
     * 不成立回退
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

    /**
     *
     * @param root 二维数组
     * @param x x轴坐标
     * @param y y轴坐标
     * @param strings 输入的字符串
     * @param z 字符串标记位
     * @param flag 负责标记的二维数组
     * @return
     */
    public static Boolean checkString(String[][] root,int x,int y,String[] strings,int z,int[][] flag){
        flag[x][y] = 1;
        if (z == strings.length-1){
            return true;
        }
        if(checkString(root,x+1,y,strings,z,flag) ||checkString(root,x,y+1,strings,z,flag)
            || checkString(root,x-1,y,strings,z,flag) || checkString(root,x,y-1,strings,z,flag)
        ) {
            return true;
        }
        flag[x][y] = 0;//回溯
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
