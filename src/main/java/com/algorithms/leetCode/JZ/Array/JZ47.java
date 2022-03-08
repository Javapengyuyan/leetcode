package com.algorithms.leetCode.JZ.Array;

public class JZ47 {

    /**
     * 礼物最大值
     * 由上面和左边来的数
     * 最大=max（上面，左边）+本格
     * 将数组作为dp记录值
     *
     * @param grid
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid[0] == null ){
            return 0;
        }
        for (int i=0;i<grid.length;i++){
            for (int j= 0;j<grid[0].length;j++){
                if (i==0 && j==0 ){
                    continue;
                }
                if (i==0){
                    grid[i][j] += grid[i][j-1];
                }else if (j==0){
                    grid[i][j] += grid[i-1][j];
                }else {
                    grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }


}
