package com.dinglevin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * 
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组
 * 1 <= numRows <= 1000
 *
 * @author dinglevin
 * @since 2021/6/27 16:36 周日
 */
public class Number0006 {
    public String convert(String s, int numRows) {
        // return new Version1().invoke(s, numRows);
        return new Version2().invoke(s, numRows);
    }

    public static class Version1 {
        public String invoke(String s, int numRows) {
            if (s == null || s.length() <= 1 || numRows == 1) {
                return s;
            }

            int actualRows = Math.min(numRows, s.length());
            List<StringBuilder> rowList = new ArrayList<StringBuilder>();
            for (int i = 0; i < actualRows; i++) {
                rowList.add(new StringBuilder());
            }

            int curRow = 0;
            boolean goDown = false;
            for (char c : s.toCharArray()) {
                rowList.get(curRow).append(c);
                if (curRow == 0 || curRow == (actualRows - 1)) {
                    goDown = !goDown;
                }
                curRow += (goDown ? 1 : -1);
            }
            
            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rowList) {
                result.append(row);
            }

            return result.toString();
        }
    }

    public static class Version2 {
        public String invoke(String s, int numRows) {
            if (s == null || s.length() == 1 || numRows == 1) {
                return s;
            }

            StringBuilder result = new StringBuilder();
            int cycleLen = 2 * numRows - 2;
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; i + j < s.length(); j += cycleLen) {
                    result.append(s.charAt(i + j));
                    if (i != 0 && i != numRows - 1 && j + cycleLen - i < s.length()) {
                        result.append(s.charAt(j + cycleLen - i));
                    }
                }
            }

            return result.toString();
        }
    }
}
