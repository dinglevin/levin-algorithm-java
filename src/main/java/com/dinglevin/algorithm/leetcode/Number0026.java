package com.dinglevin.algorithm.leetcode;

/**
 * 26. 删除有序数组中的重复项
 * 
 * @author dinglevin
 * @since 2024-10-01 23:08:19
 */
public class Number0026 {
    public int removeDuplicates(int[] nums) {
        return new Version1().invoke(nums);
    }

    public static class Version1 {
        public int invoke(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int k = 0, i = 0;
            while (i < nums.length) {
                if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                    continue;
                }
                nums[k++] = nums[i++];
            }

            return k;
        }
    }
}
