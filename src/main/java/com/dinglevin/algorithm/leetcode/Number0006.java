package com.dinglevin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：Number6
 *
 * @author dinglevin
 * @since 2021/6/27 16:36 周日
 */
public class Number0006 {
    public String version1Convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rowList = new ArrayList<>();
        int rowSize = Math.min(numRows, s.length());
        for (int i = 0; i < rowSize; i++) {
            rowList.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            rowList.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : rowList) {
            result.append(builder.toString());
        }
        return result.toString();
    }

    public String version2Convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int len = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < len; j += cycleLen) {
                result.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < len) {
                    result.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return result.toString();
    }
}
