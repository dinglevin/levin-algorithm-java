package com.dinglevin.algorithm.leetcode;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 
 * 说明：你不能倾斜容器。
 * 
 * 示例1:
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * 
 * 提示：
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 
 * @author dinglevin
 * @since 2024-09-12 00:01:55
 */
public class Number0011 {
    public int maxArea(int[] height) {
        return new Version1().invoke(height);
    }

    public static class Version1 {
        public int invoke(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = -1;

            while (left < right) {
                int width = right - left;
                int minHeight = Math.min(height[left], height[right]);
                int area = width * minHeight;

                maxArea = Math.max(maxArea, area);

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
    }
}
