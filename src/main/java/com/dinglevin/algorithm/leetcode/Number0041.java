package com.dinglevin.algorithm.leetcode;

/**
 * 描述：Number41
 *
 * @author dinglevin
 * @since 2021/6/18 11:54 周五
 */
public class Number0041 {
    public int version2FirstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public int version1FirstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int max = len + 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = max;
            }
        }

        for (int i = 0; i < len; i++) {
            int value = Math.abs(nums[i]);
            if (value <= len && nums[value - 1] > 0) {
                nums[value - 1] = -nums[value - 1];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return max;
    }
}
