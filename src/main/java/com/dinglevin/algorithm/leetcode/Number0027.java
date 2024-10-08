package com.dinglevin.algorithm.leetcode;

/**
 * 27. 移除元素
 * 
 * @author dinglevin
 * @since 2024-10-08 23:08:11
 */
public class Number0027 {
    public int removeElement(int[] nums, int val) {
        return new Version1().invoke(nums, val);
    }

    public static class Version1 {
        public int invoke(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int p = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[p++] = nums[i];
                }
            }

            return p;
        }
    }
}
