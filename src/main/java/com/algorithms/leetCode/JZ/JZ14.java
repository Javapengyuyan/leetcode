package com.algorithms.leetCode.JZ;

public class JZ14 {
    public static int cuttingRope(int n) {
        int p = 1000000007;
        if (n < 3){
            return 1;
        }
        if (n ==3){
            return 2;
        }
        int num = n%3;
        if (num == 0){
            return (int) Math.pow(3,n/3);
        }else if (num == 1){
            return (int) (Math.pow(3,(n-4)/3))*4;
        }else {
            return (int) Math.pow(3,(n-2)/3)*2;
        }

    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(cuttingRope(num));

        int n = 120;
        System.out.println(Math.pow(3,n/3)%1000000007);

       /* if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);*/


    }

}
