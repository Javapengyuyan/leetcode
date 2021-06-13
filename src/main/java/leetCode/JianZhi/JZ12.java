package leetCode.JianZhi;

public class JZ12 {

    /**
     * 回溯算法，通过循环中调用递归函数
     *
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        //标记数组
        int[][] sign = new int[board.length][board[0].length];
        //遍历数组起始点
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                //判断起始点是否符合要求
                dfs();
            }
        }

        return false;
    }

    //深度优先搜索
    public boolean dfs(){

        return false;
    }


}
