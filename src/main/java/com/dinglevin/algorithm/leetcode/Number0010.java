package com.dinglevin.algorithm.leetcode;

/**
 * 正则表达式匹配
 * 
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
 * 
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 
 * 示例 2:
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 
 * 示例 3：
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 
 * 提示：
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 * 
 * @author dinglevin
 * @since 2024-09-06 00:10:29
 */
public class Number0010 {
    public boolean isMatch(String s, String p) {
        return new Version1().invoke(s, p);
    }

    public static class Version1 {
        public boolean invoke(String s, String p) {
            // 语法错误
            if ("*".equals(p)) {
                return false;
            }

            int m = s.length();
            int n = p.length();

            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;

            for (int i = 0; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }

            return f[m][n];
        }

        private boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }

            return (p.charAt(j - 1) == '.') || (s.charAt(i - 1) == p.charAt(j - 1));
        }
    }
}
