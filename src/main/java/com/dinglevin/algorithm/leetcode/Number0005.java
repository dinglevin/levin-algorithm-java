package com.dinglevin.algorithm.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * @author dinglevin
 * @since 2021/6/22 19:53 周二
 */
public class Number0005 {
    public String longestPalindrome(String s) {
        // return new Version1().invoke(s);
        return new Version2().invoke(s);
    }

    public static class Version1 {
        public String invoke(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }

            int maxLen = 1, start = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (isPalindrome(i, j, s)) {
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            start = i;
                        }
                    }
                }
            }

            return s.substring(start, start + maxLen);
        }

        private boolean isPalindrome(int start, int end, String s) {
            for (int i = 0; i < (end - start + 1) / 2; i++) {
                if (s.charAt(start + i) != s.charAt(end - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class Version2 {
        public String invoke(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }

            int maxLen = 0, start = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
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
                        start = i;
                    }
                }
            }

            return s.substring(start, start + maxLen);
        }
    }

    public static class Version3 {
        public String invoke(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i); // Odd length palindromes
                int len2 = expandAroundCenter(s, i, i + 1); // Even length palindromes
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }
    
        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }
}
