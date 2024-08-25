/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
package com.dinglevin.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author dinglevin
 * @since 2024/4/10 20:43
 */
public class Number0001 {
    private Number0001() {
    }

    public static int[] twoSum(int[] nums, int target) {
        return new Version1().invoke(nums, target);
        // return new Version2().invoke(nums, target);
        // return new Version3().invoke(nums, target);
    }

    public static class Version1 {
        public int[] invoke(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
    
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
    
            return new int[0];
        }
    }

    public static class Version2 {
        public int[] invoke(int[] nums, int target) {
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
    }

    public static class Version3 {
        public int[] invoke(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
    
            int[] sortedNum = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sortedNum);
            int left = 0;
            int right = nums.length - 1;
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

        private int findIndex(int[] nums, int value, boolean reverse) {
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
}
