package niuke.meiTuan;

import java.util.Scanner;

public class qz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer aLength = Integer.valueOf(scanner.nextLine());
        String secondLine = scanner.nextLine();
        String[] a = secondLine.split("\\s+");
        int[] b = new int[aLength];
        for (int i=0;i<aLength-1;i++){
            b[i] = Integer.valueOf(a[i]);
            b[i] = b[i] ^ Math.floorMod(1,i+1);
        }
        int val = b[0]^b[1];
        for (int i=2;i<b.length;i++){
            val = val ^ b[i];
        }
        System.out.println(val);
    }

}
