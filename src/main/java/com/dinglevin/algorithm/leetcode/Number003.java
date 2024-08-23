/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。 
 * 
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
package com.dinglevin.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Number003 {
    private Number003() {
    }

    public static int lengthOfLongestSubstring(String s) {
        return new Version1().invoke(s);
        // return new Version2().invoke(s);
    }

    public static class Version1 {
        public int invoke(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int maxLen = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Integer existsIndex = map.get(c);
                if (existsIndex != null && existsIndex >= start) {
                    start = existsIndex + 1;
                }
                maxLen = Math.max(maxLen, i - start + 1);
                map.put(c, i);
            }

            return maxLen;
        }
    }

    public static class Version2 {
        public int invoke(String s) {
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                Set<Character> charSet = new HashSet<>();
                charSet.add(s.charAt(i));
    
                int j = i + 1;
                while (j < s.length() && !charSet.contains(s.charAt(j))) {
                    charSet.add(s.charAt(j));
                    j++;
                }
    
                maxLen = Math.max(maxLen, charSet.size());
            }
            return maxLen;
        }
    }
}
