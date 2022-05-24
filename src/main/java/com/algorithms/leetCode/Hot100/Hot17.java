package com.algorithms.leetCode.Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: long
 * @create: 2022-03-10 22:55
 * @Description hot100第17题、电话号码字母组合
 *  * 2-9八个字母，输出所有的可能
 **/

public class Hot17 {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(null,null);
        Object o1 = hashMap.get(null);
        System.out.println(o1);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(1,1);
        Object o = concurrentHashMap.get(null);
        System.out.println(o);
        //List<String> list = letterCombinations("23");
        //System.out.println(list);
    }

    static public List<String> letterCombinations(String digits) {
        if (digits.length()<1){
            return new ArrayList<>();
        }
        Map<String,String> map = new HashMap(9);
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        //回溯遍历
        ArrayList<String> arrayList = new ArrayList<>();
        backTrack(arrayList,digits,0,map,new StringBuilder());
        return arrayList;
    }

    static private void backTrack(ArrayList list,String digits,int a,
                                  Map<String,String> map,StringBuilder phoneNum) {
        if (phoneNum.length() == digits.length()){
            list.add(phoneNum.toString());
        }else {
            char aChar = digits.charAt(a);
            String s = map.get(String.valueOf(aChar));
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                phoneNum.append(c);
                backTrack(list,digits,a+1,map,phoneNum);//不需要a本身数值增加的话用+1运算
                phoneNum.deleteCharAt(a);
            }
        }

    }

}


class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap,
                          String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
