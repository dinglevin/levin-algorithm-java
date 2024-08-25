package com.dinglevin.algorithm.leetcode;

/**
 * 描述：Number2005
 *
 * @author dinglevin
 * @since 2021/6/15 20:03 周二
 */
public class Number2005 {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        boolean[] array = new boolean[14];
        int zeroCount = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (array[nums[i]]) {
                    return false;
                }

                array[nums[i]] = true;
                if (nums[i] < min) {
                    min = nums[i];
                }
            } else {
                zeroCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = i + min;
            if (index > 13) {
                if (i + zeroCount == 5) {
                    return true;
                }
                return false;
            }

            if (!array[index]) {
                zeroCount--;
                if (zeroCount < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
