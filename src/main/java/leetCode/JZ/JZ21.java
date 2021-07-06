package leetCode.JZ;

public class JZ21 {

    /**
     * 奇、偶排序
     *
     * 可以使用双指针前后进行排序
     * @param nums
     * @return
     */
    //todo 双指针实验
    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];
        int odd = 0;
        int even = nums.length-1;
        for (int i=0;i<nums.length;i++){
            if ( nums[i]%2 == 0 ){
                result[even] = nums[i];
                even--;
            }else {
                result[odd] = nums[i];
                odd++;
            }
        }
        return result;

    }
}
