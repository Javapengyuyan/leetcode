package com.algorithms.graphAlgorithm.ChapterFour;

public class TestQuick {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortArray(new int[]{1,3}));

    }
    static class Solution {
        int[] tmp;

        public int[] sortArray(int[] nums) {
            tmp = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void mergeSort(int[] nums, int l, int r) {
            if (l >= r) {
                return;
            }
            int mid = (l + r) >> 1;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            int i = l, j = mid + 1;
            int cnt = 0;
            while (i <= mid && j <= r) {
                if (nums[i] <= nums[j]) {
                    tmp[cnt++] = nums[i++];
                } else {
                    tmp[cnt++] = nums[j++];
                }
            }
            while (i <= mid) {
                tmp[cnt++] = nums[i++];
            }
            while (j <= r) {
                tmp[cnt++] = nums[j++];
            }
            for (int k = 0; k < r - l + 1; ++k) {
                nums[k + l] = tmp[k];
            }
        }
    }

}
