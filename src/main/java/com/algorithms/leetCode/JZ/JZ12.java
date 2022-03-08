package com.algorithms.leetCode.JZ;

public class JZ12 {

    public static void main(String[] args) {
        //char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'a','b'}};
        String word = "ba";
        System.out.println(exist(board,word));
    }

    //DFS  二维数组中的x、y和坐标系中的xy要对应上，int[0].length才是x
    public static boolean exist(char[][] board, String word) {
        if (word == null){
            return true;
        }
        if (board == null){
            return false;
        }

        boolean[][] visit = new boolean[board.length][board[0].length];
        //遍历每个节点，进行DFS测试
        for (int x=0;x<board[0].length;x++){
            for (int y =0;y<board.length;y++){
                if (DFS(board,x,y,0,word.toCharArray(),visit)){
                    return true;
                }

            }

        }
        return false;
    }

    public static boolean DFS(char[][] board,int x,int y ,int k,char[] word,boolean[][] visit){
        if (x<0|| y<0|| y>board.length-1 || x>board[0].length-1 || board[y][x] != word[k] ||
            visit[y][x] == true){
            return false;
        }
        if (k == word.length-1){
            return true;
        }
        visit[y][x] = true;
        boolean re = (DFS(board,x+1,y,k+1,word,visit) || DFS(board,x-1,y,k+1,word,visit) ||
                DFS(board,x,y+1,k+1,word,visit) ||DFS(board,x,y-1,k+1,word,visit));
        visit[y][x] = false;
        return re;
    }

}
