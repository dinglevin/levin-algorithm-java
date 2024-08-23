/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5 
 * 
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 */
package com.dinglevin.algorithm.leetcode;

public class Number004 {
    private Number004() {
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (isEmpty(nums1) && isEmpty(nums2)) {
            return 0D;
        }

        return new Version1().invoke(nums1, nums2);
        // return new Version2().invoke(nums1, nums2);
    }

    private static boolean isEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }

    public static class Version1 {
        public double invoke(int[] nums1, int[] nums2) {
            int totalLen = nums1.length + nums2.length;
            int leftIdx = totalLen % 2 == 0 ? (totalLen / 2) - 1 : (totalLen - 1) / 2;
            int rightIdx = totalLen % 2 == 0 ? (totalLen / 2) : (totalLen - 1) / 2;

            int i = 0, j = 0;
            int curIdx = 0;
            int left = 0, right = 0;
            while (i < nums1.length || j < nums2.length) {
                boolean b = choose(nums1, i, nums2, j);
                if (b) {
                    if (curIdx == leftIdx) {
                        left = nums1[i];
                    }
                    if (curIdx == rightIdx) {
                        right = nums1[i];
                    }
                    i++;
                } else {
                    if (curIdx == leftIdx) {
                        left = nums2[j];
                    }
                    if (curIdx == rightIdx) {
                        right = nums2[j];
                    }
                    j++;
                }

                curIdx++;
                if (curIdx > leftIdx && curIdx > rightIdx) {
                    break;
                }
            }
    
            return (left + right) / (double) 2;
        }

        private boolean choose(int[] nums1, int i, int[] nums2, int j) {
            if (i >= nums1.length) {
                return false;
            }
            if (j >= nums2.length) {
                return true;
            }

            return nums1[i] <= nums2[j];
        }
    }

    public static class Version2 {
        public double invoke(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int left = (len1 + len2 + 1) / 2;
            int right = (len1 + len2 + 2) / 2;

            if (left == right) {
                return getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left);
            }

            int mid1 = getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left);
            int mid2 = getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right);
            return (mid1 + mid2) * 0.5;
        }

        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;

            if (len1 == 0) {
                return nums2[start2 + k - 1];
            } else if (len2 == 0) {
                return nums1[start1 + k - 1];
            } else if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }

            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;
            if (nums1[i] > nums2[j]) {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            } else {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            }
        }
    }
}
