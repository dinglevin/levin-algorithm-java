package com.dinglevin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 
 * 提示：
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5

 * @author dinglevin
 * @since 2024-09-19 23:40:26
 */
public class Number0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        return new Version1().invoke(nums);
    }

    public static class Version1 {
        public List<List<Integer>> invoke(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int x = nums.length - 1;
                int target = -nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    while (j < x && nums[j] + nums[x] > target) {
                        --x;
                    }

                    if (j == x) {
                        break;
                    }

                    if (nums[j] + nums[x] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[x]);
                        result.add(list);
                    }
                }
            }

            return result;
        }
    }
}
