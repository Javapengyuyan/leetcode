package Test;

import java.util.Scanner;

public class DescLink {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number1 = scanner.nextLine();
        Integer firstLinkLength = Integer.parseInt(number1.trim());
        String firstStringLink = scanner.nextLine();
        String number2 = scanner.nextLine();
        Integer secondLinkLength = Integer.parseInt(number2.trim());
        String secondStringLink = scanner.nextLine();
        //第一个数组赋值
        String[] firstString = firstStringLink.split("\\s+");
        int[] firstLink = new int[firstLinkLength];
        for (int i=0;i<firstString.length;i++){
            firstLink[i] = Integer.parseInt( firstString[i].trim() );
        }
        //第二个数组赋值
        String[] secondString = secondStringLink.split("\\s+");
        int[] secondtLink = new int[secondLinkLength];
        for (int i=0;i<secondString.length;i++){
            secondtLink[i] = Integer.parseInt( secondString[i].trim() );
        }
        Integer number = new Integer(0);//对比的位置
        for (int i=0;i<firstLink.length;i++){
            for (int j =number;j<secondtLink.length;j++){
                if ( secondtLink[j] == firstLink[i] ){
                    System.out.print(firstLink[i] + " ");
                    number = j;
                    break;
                }

            }

        }

    }

}
