package niuke.meiTuan;

import java.util.HashSet;
import java.util.Scanner;

public class zddp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] firstLineNum = firstLine.split("\\s+");
        int n = Integer.valueOf(firstLineNum[0]);
        int p = Integer.valueOf(firstLineNum[1]);
        int q = Integer.valueOf(firstLineNum[2]);
        String secondLine = scanner.nextLine();
        String[] secondNum = secondLine.split("\\s+");
        HashSet a = new HashSet();
        for (int i=0;i<secondNum.length;i++){
            a.add( secondNum[i] );
        }
        String thirdLine = scanner.nextLine();
        String[] thirdNum = thirdLine.split("\\s+");
        HashSet both = new HashSet();
        for (int i=0;i<thirdNum.length;i++){
            if (a.contains(thirdNum[i])){
                both.add(thirdNum[i]);
            }
        }
        System.out.println( (p-both.size())+" "+(q-both.size())+" "+both.size() );

    }

}
