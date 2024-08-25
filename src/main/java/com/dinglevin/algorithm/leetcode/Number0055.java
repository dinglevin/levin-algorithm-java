package com.dinglevin.algorithm.leetcode;

/**
 * 描述：Number55
 *
 * @author dinglevin
 * @since 2021/6/20 20:04 周日
 */
public class Number0055 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        int rightMost = 0;
        for (int i = 0; i < len; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
