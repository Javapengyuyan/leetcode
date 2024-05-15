package com.personal.leetcode.Test;

import java.util.*;

public class MeiTuan {
    static public void sortNum(){
        Scanner scanner = new Scanner(System.in);
        //数组个数
        Integer intNum = scanner.nextInt();
        List resultList = new ArrayList(intNum);
        List<String> scanString = new ArrayList<>(intNum);
        List<Integer> scanlistLength = new ArrayList();
        for (int i=0;i<intNum;i++){
            //数组长度
            Integer listLength = scanner.nextInt();
            scanlistLength.add(listLength);
            String array = scanner.nextLine();
            //数组
            String line = scanner.nextLine();
            scanString.add(line);

        }
        for (int i=0;i<scanString.size();i++) {
            String[] strings = scanString.get(i).split(" ");
            if (strings.length != scanlistLength.get(i)){
                resultList.add(false);
                continue;
            }
            //排序
            List<Integer> integerList = new ArrayList<>(strings.length);
            HashMap<String,Integer> map = new HashMap();
            for (int j=0;j<strings.length;j++){
                String num = strings[j];
                Integer mapNum = map.get(num);
                if (mapNum != null){
                    resultList.add(false);
                    continue;
                }else {
                    integerList.add(Integer.valueOf(num));
                    map.put(num,1);
                }
            }
            Collections.sort(integerList);
            Integer first = integerList.get(0);
            Integer last = integerList.get(integerList.size()-1);
            if (first != 1 || last != integerList.size()){
                resultList.add(false);
                continue;
            }
            resultList.add(true);
        }

        for (Object o : resultList) {
            System.out.println(o);
        }

    }



    public static void main(String[] args) {
        sortNum();
    }

}
