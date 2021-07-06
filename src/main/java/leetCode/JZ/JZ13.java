package leetCode.JZ;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class JZ13 {
    static int m,n,k;
    static boolean[][] visited;
    public static void main(String[] args) {
        m = 1;
        n = 2;
        k = 1;
        //System.out.println(movingCount(m,n,k));
        System.out.println(BFS(m,n,k));

    }

    /*class Solution {
        int m, n, k;
        boolean[][] visited;
        public int movingCount(int m, int n, int k) {
            this.m = m; this.n = n; this.k = k;
            this.visited = new boolean[m][n];
            return dfs(0, 0, 0, 0);
        }
        public int dfs(int i, int j, int si, int sj) {
            if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
            visited[i][j] = true;
            return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
        }
    }*/
    /**
     * DFS 深度优先搜索
     *
     */
    public static int movingCount(int m,int n,int k){
        visited = new boolean[m][n];
        return  dfs(0,0,0,0);
    }

    public static int dfs(int x,int y,int xn,int yn){
        if (xn+yn > k || x>=m || y>=n){
            return 0;
        }
        visited[x][y] = true;
        return 1+ dfs(x+1,y,numVal(x+1),numVal(y))+dfs(x,y+1,numVal(x),numVal(y+1));
    }

    public static int numVal(int num){
        if (num <10){
            return num;
        }
        int sum = 0;
        sum = num/10 + num%10;
        return sum;

    }

    /**
     * BFS
     */
    public static int BFS(int m,int n,int k){
        visited = new boolean[m][n];
        Queue queue = new ArrayDeque();
        queue.add(new int[]{0,0,0,0});
        int sum = 0;
        while (!queue.isEmpty()){
            int[] ints = (int[]) queue.poll();
            int x = ints[0];
            int y = ints[1];
            int xi = ints[2];
            int yi = ints[3];
            if (x > m-1 || y > n-1 || (numVal(xi)+numVal(yi)>k) ){
                continue;
            }
            queue.add(new int[]{x+1,y,xi+1,yi});
            queue.add(new int[]{x,y+1,xi,yi+1});
            visited[x][y] = true;

            sum ++;
        }
        return sum;

    }
    public int movingCountBfs(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<int[]>();
        queue.add(new int[] { 0, 0, 0, 0 });
        while(queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res ++;
            queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }



}
