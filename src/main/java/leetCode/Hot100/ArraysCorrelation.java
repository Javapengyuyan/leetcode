package leetCode.Hot100;

public class ArraysCorrelation {
    /**
     * 排序数组进行查找定位--想到二分查找
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {}, nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    /**
     *
     * 这种写法不好，需要多种判断边界问题
     *
     * @param nums1
     * @param nums2
     * @return
     */
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if (sum == 1){
            int result = nums1.length ==0? nums2[0]: nums1[0];
            return result;
        }
        int mod = sum%2;
        double result = 0;
        boolean one = true;
        double mid = Math.ceil(sum/2);
        if (mod == 0){
            one = false;
        }
        int i=0,j=0,k=0;
        boolean switchij = true;
        while (i<mid){
            if (!one){
                if (i== mid-2){
                    if (switchij){
                        result += nums2[i];
                    }else {
                        result += nums1[j];
                    }
                }
            }
            if (i== mid-1){
                if (switchij){
                    result += nums2[i];
                }else {
                    result += nums1[j];
                }
            }

            if (nums1[j]<nums2[k]){
                j++;
                switchij = false;
            }else {
                k++;
            }
            i++;
        }
        return one?result:result/2;

    }

    /**
     * 要让时间复杂度变为log(m+n)用二分查找
     *
     */


    /**
     *  最长回文子串
     *  状态转移方程
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {


        return null;
    }


}
