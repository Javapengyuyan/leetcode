package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Middle {
    public static void main(String[] args) {
        //n个数删除一个，余下中位数
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        Integer firstLinkLength = Integer.parseInt(number.trim());
        String firstStringLink = scanner.nextLine();
        //数组赋值
        String[] firstString = firstStringLink.split("\\s+");
        int[] firstLink = new int[firstLinkLength];//原数组
        int[] numbers = new int[firstLinkLength];//排序后数组
        for (int i=0;i<firstString.length;i++){
            firstLink[i] = Integer.parseInt( firstString[i].trim() );
            numbers[i] = Integer.parseInt( firstString[i].trim() );
        }
        //数组排序
        for(int i=0;i<numbers.length-1;i++) {
            for(int j=0;j<numbers.length-1-i;j++) {
                if(numbers[j]>numbers[j+1]) {
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        Map<Integer,Integer> map = new HashMap();
        for (int i=0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }
        Integer mid = firstLinkLength/2;
        for (int i=0;i<firstLink.length;i++){
            Integer position = map.get(firstLink[i]);
            if (position<mid){
                System.out.println( numbers[mid] );
            }else {
                System.out.println( numbers[mid-1] );
            }
        }
    }

}
