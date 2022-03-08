package com.algorithms.leetCode.backTracking;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ALL007 {

    class Inner{}

    public void TEst(){
        Integer integer = 1;
        new Inner(){
          void test(){
              System.out.println("这是个内部类的方法");
          }

        };


    }

    public static void main(String[] args) {
        //int[] ints = {2,3,1,4,5,-7,3};
        int[] ints = {3};
        new ALL007().TEst();

        ThreadFactory threadFactory = new ThreadPoolTaskExecutor();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
                (10, 20, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                         Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(2);
        Executors.newSingleThreadScheduledExecutor();
        //ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor();

    }


    static List<List<Integer>> result = new ArrayList<>();
    static public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        baskT(new ArrayList(),nums);
        return result;
    }
    //三个数字之和为0
    static public void baskT(ArrayList list,int[] nums){
        for (int i=0;i<nums.length-2;i++){
            // i去重
            if (i>0 && nums[i-1] == nums[i] ){
                continue;
            }
            list.add(nums[i]);
            //优化为双指针
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[right]+nums[left]+nums[i];
                if (sum > 0){
                    right--;
                }else if (sum ==0 ){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //++i为前缀运算，先+后计算函数，i++为后缀运算
                    while (left<right && nums[left]==nums[++left] ){
                    }
                    while (left<right && nums[right]==nums[--right] ){
                    }
                }else if (sum < 0){
                    left++;
                }
            }

        }
    }


    /**
     * 008
     * 和>=target的最短数组
     */
    static public int minSubArrayLen(int target, int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int left = 0;
        int sum = 0;
        int reslut = Integer.MAX_VALUE;
        for (int right=0;right<nums.length;right++){
            sum += nums[right];
            while (sum >= target && left<=right){
                reslut = Math.min(reslut,right-left+1);
                sum = sum - nums[left++];
            }
        }
        return reslut==Integer.MAX_VALUE?0:reslut;
    }

    /**
     * 01
     * 两数字之和target
     */
    static public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            for (int j= i+1;j<nums.length;j++){
                int sum = nums[i]+nums[j];
                if (sum == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    //优化  创建Hash表


}
