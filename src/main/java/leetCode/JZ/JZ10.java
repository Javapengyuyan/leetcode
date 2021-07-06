package leetCode.JZ;

public class JZ10 {
    public static void main(String[] args) {
        int i=1,j=1,sum =0;
        int time = 18;
        for (int x=0;x<time;x++){
            sum = (i + j) % 1000000007;
            i = j;
            j = sum;
        }
        System.out.println(i);

    }

}
