package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Notification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();//有n个人
        Integer m = scanner.nextInt();//m个团队
        List<String> stringList = new ArrayList();
        for (int i=0;i<m+1;i++){
            stringList.add(scanner.nextLine());
        }
        for (int i=0;i<stringList.size();i++){
            String[] strings = stringList.get(i).split("\\s+");
            int[] link = new int[Integer.valueOf( strings[0].trim() )];
            for (int j=0;j<strings.length-1;j++){
                link[j] = Integer.parseInt( strings[j+1].trim() );
            }
        }

    }

}
