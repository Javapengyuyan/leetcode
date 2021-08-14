package leetCode.dynamicProgramming;

public class DynamicTest {
    /**
     * 动态规划
     */
    //爬楼梯 f(n)=f(n-1)+f(n-2)
    static int sum = 0;
    static public int plt(int num){
        if (num <=2){
            return num;
        }
        return plt(num-1)+plt(num-2);

    }
    //非递归方式
    public int climb(int n){
        int x=0,y=0,sum =1;
        for (int i=0;i<=n;i++){
            x=y;
            y = sum;
            sum = x+y;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(plt(5));

    }

}
