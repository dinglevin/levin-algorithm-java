package com.dinglevin.algorithm.leetcode;

/**
 * 描述：Number5
 *
 * @author dinglevin
 * @since 2021/6/22 19:53 周二
 */
public class Number0005 {
    public String version1LongestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int len = s.length();
        int maxLen = 0, startMax = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s, i, j)) {
                    if (maxLen < (j - i + 1)) {
                        maxLen = j - i + 1;
                        startMax = i;
                    }
                }
            }
        }

        return s.substring(startMax, maxLen + 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        int len = (end - start + 1) / 2;
        for (int i = 0; i < len; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }

    public String version2LongestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int len = s.length();
        if (len == 1) {
            return s;
        }

        int maxLen = 0, maxStart = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && maxLen < (j - i + 1)) {
                    maxLen = j - i + 1;
                    maxStart = i;
                }
            }
        }

        return s.substring(maxStart, maxStart + maxLen);
    }
}
