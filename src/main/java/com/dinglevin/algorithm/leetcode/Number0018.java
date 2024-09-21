package com.dinglevin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] 
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * 你可以按 任意顺序 返回答案 。
 * 
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * 
 * 提示：
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * @author dinglevin
 * @since 2024-09-21 16:23:43
 */
public class Number0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return new Version1().invoke(nums, target);
    }

    public static class Version1 {
        public List<List<Integer>> invoke(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return result;
            }

            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if ((long)nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }

                for (int j = i + 1; j < len - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 1] > target) {
                        break;
                    }
                    if ((long)nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                        continue;
                    }

                    int left = j + 1, right = len - 1;
                    while (left < right) {
                        long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }

            return result;
        }
    }
}
