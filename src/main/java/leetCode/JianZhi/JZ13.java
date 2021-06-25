package leetCode.JianZhi;

public class JZ13 {

    int m,n,k;

    public void bot(int m,int n,int k){
        boolean[][] b;


        dfs(0,0,0,0);

    }

    public int dfs(int i,int j,int si,int sj){
        if (i>m || j>n || si >k || sj > k ){
            return 0;
        }else {
            //向右 向下
            return dfs()+1;
        }

    }

    //数字求和
    public static int splitNum(int num){
        if (num < 10){
            return num;
        }else {
            String[] strings = String.valueOf(num).split("");
            int n = 0 ;
            for (String s : strings){
                n = n + Integer.valueOf(s);
            }
            return n;
        }
    }

    public static void main(String[] args) {
        System.out.println(splitNum(123));

    }


}
