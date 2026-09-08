package com.dinglevin.algorithm.leetcode;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 
 * @author dinglevin
 * @since 2024-10-09 23:43:00
 */
public class Number0028 {
    public int strStr(String haystack, String needle) {
        return new Version1().invoke(haystack, needle);
    }

    public static class Version1 {
        public int invoke(String hayStack, String needle) {
            for (int i = 0; i <= hayStack.length() - needle.length(); i++) {
                if (hayStack.startsWith(needle, i)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
