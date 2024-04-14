package com.dinglevin.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author dinglevin
 * @since 2024/4/10 20:43
 */
public class Number001 {
    public static void main(String[] args) {
        System.out.println("V0: " + JSON.toJSONString(twoSumV0(new int[]{3, 2, 4}, 6)));
        System.out.println("V1: " + JSON.toJSONString(twoSumV1(new int[]{3, 2, 4}, 6)));
        System.out.println("V2: " + JSON.toJSONString(twoSumV2(new int[]{3, 3}, 6)));
    }

    public static int[] twoSumV0(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[0];
    }

    public static int[] twoSumV1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

    public static int[] twoSumV2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] sortedNum = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNum);
        int left = 0, right = nums.length - 1;
        while (left != right) {
            int sum = sortedNum[left] + sortedNum[right];
            if (sum == target) {
                return new int[] { findIndex(nums, sortedNum[left], false),
                        findIndex(nums, sortedNum[right], true) };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }

    private static int findIndex(int[] nums, int value, boolean reverse) {
        if (reverse) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (value == nums[i]) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (value == nums[i]) {
                    return i;
                }
            }
        }
        return -1;
    }
}
