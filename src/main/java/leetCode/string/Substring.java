package leetCode.string;

import niuke.common.ListNode;
import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
import java.util.HashSet;

public class Substring {
    /**
     * 找出最长不重复字串
     * 解法：滑动窗口 设置双指针，left。right，修改右边指针，逐渐移动达到目标后，移动左边指针
     * 额外空间记录移动数据是否符合
     * 时间复杂度：O(m+n)，两个字符串的长度。
     * @param
     * @return
     */
    static public int lengthOfLongestSubstring(String s) {
        if (Strings.isBlank(s)){
            return 0;
        }
        int result = -1;
        int left = 0, right = 0;
        HashSet stringSet = new HashSet();
        char[] chars = s.toCharArray();
        while (right<s.length()-1){
            //右端不重复长度寻找
            boolean repetition = true;
            while (repetition){
                if (stringSet.contains(chars[right])){
                    repetition = false;
                    continue;
                }
                result = Math.max(result,right-left+1);
                stringSet.add(chars[right]);
                right++;
            }
            //左端不重复寻找
            boolean leftRepetition = true;
            while (leftRepetition && left <s.length()){
                if (chars[left] == chars[right]){
                    leftRepetition= false;
                    left++;
                    right++;
                    continue;
                }
                //取消重复
                stringSet.remove(chars[left]);
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(formatList(head));*/
        String s = "awfoubanwf";
        //System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringaaa(s));

    }

    static public int lengthOfLongestSubstringaaa(String s) {
        if (s.length()==0) return 0;
        int left = 0,max = 0;
        HashMap<Character,Integer> hashMap = new HashMap();
        for (int i=0;i<s.length();i++){
            if (hashMap.containsKey(s.charAt(i))){
                left = Math.max(left,hashMap.get(s.charAt(i))+1);
            }
            hashMap.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    static public ListNode formatList (ListNode head) {
        if(head == null){
            return head;
        }
        ListNode start = new ListNode(head.val);
        ListNode startfather = new ListNode(0);
        startfather.next = start;
        ListNode end = new ListNode(head.val);
        ListNode endfather = new ListNode(0);
        endfather.next = end;
        head = head.next;
        boolean sore = false;
        while(head != null){
            if(!sore){//尾节点
                ListNode newend = new ListNode(head.val);
                end.next = newend;
                end = end.next;
                sore = true;
            }else{
                ListNode newstart = new ListNode(head.val);
                newstart.next = start;
                start = newstart;
                sore = false;
            }
            head = head.next;
        }
        startfather.next.next = endfather.next.next;
        return start;
    }


    /*HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int max = 0;
    int left = 0;
        for(int i = 0; i < s.length(); i ++){
        if(map.containsKey(s.charAt(i))){
            left = Math.max(left,map.get(s.charAt(i)) + 1);
        }
        map.put(s.charAt(i),i);
        max = Math.max(max,i-left+1);
    }*/
}
