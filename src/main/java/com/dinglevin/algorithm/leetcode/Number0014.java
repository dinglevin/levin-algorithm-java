package com.dinglevin.algorithm.leetcode;

/**
 * 
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成

 * @author dinglevin
 * @since 2024-09-18 23:51:29
 */
public class Number0014 {
    public String longestCommonPrefix(String[] strs) {
        return new Version1().invoke(strs);
    }

    public static class Version1 {
        public String invoke(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }

            StringBuilder builder = new StringBuilder();
            outer: for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                        break outer;
                    }
                }
                builder.append(c);
            }
            return builder.toString();
        }
    }
}
