package com.dinglevin.algorithm.others;

/**
 * 描述：LongestCommonSubString
 *
 * @author dinglevin
 * @since 2021/6/4 17:42 周五
 */
public class LongestCommonSubString {
    /**
     * 最原始暴力破解法
     *
     * @param text1
     * @param text2
     * @return
     */
    public Result executeV1(String text1, String text2) {
        Result result = new Result(0, "");
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) != text2.charAt(j)) {
                    continue;
                }

                int temp = 1;
                while (i + temp < text1.length() && j + temp < text2.length()) {
                    if (text1.charAt(i + temp) != text2.charAt(j + temp)) {
                        break;
                    }
                    temp++;
                }

                if (temp > result.getMaxLen()) {
                    result.setMaxLen(temp);
                    result.setSubString(text1.substring(i, i + temp));
                }
            }
        }
        return result;
    }

    /**
     * 动态规划法：矩阵M*N
     * 参考：https://blog.csdn.net/u013309870/article/details/69479488
     *
     * @param text1
     * @param text2
     * @return
     */
    public Result executeV2(String text1, String text2) {
        int[][] matrix = new int[text1.length()][text2.length()];
        Result result = new Result(0, null);

        int endIndex = -1;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                } else {
                    matrix[i][j] = 0;
                }

                if (matrix[i][j] > result.getMaxLen()) {
                    result.setMaxLen(matrix[i][j]);
                    endIndex = i;
                }
            }
        }

        if (result.getMaxLen() > 0) {
            result.setSubString(text1.substring(endIndex - result.getMaxLen() + 1, endIndex + 1));
        }

        return result;
    }

    /**
     * 动态规划法：不用矩阵，只计算对角线上的值
     * 参考：https://blog.csdn.net/u013309870/article/details/69479488
     *
     * @param text1
     * @param text2
     * @return
     */
    public Result executeV3(String text1, String text2) {
        Result result = new Result(0, null);

        int endIndex = -1;
        int row = 0;
        int col = text2.length() - 1;
        int len = 0;
        while (row < text1.length()) {
            int i = row;
            int j = col;
            while (i < text1.length() && j < text2.length()) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    len++;
                    if (len > result.getMaxLen()) {
                        result.setMaxLen(len);
                        endIndex = i;
                    }
                } else {
                    len = 0;
                }
                i++;
                j++;
            }

            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }

        if (result.getMaxLen() > 0) {
            result.setSubString(text1.substring(endIndex - result.getMaxLen() + 1, endIndex + 1));
        }

        return result;
    }

    public static class Result {
        private int maxLen;
        private String subString;

        public Result(int maxLen, String subString) {
            this.maxLen = maxLen;
            this.subString = subString;
        }

        public int getMaxLen() {
            return maxLen;
        }

        public void setMaxLen(int maxLen) {
            this.maxLen = maxLen;
        }

        public String getSubString() {
            return subString;
        }

        public void setSubString(String subString) {
            this.subString = subString;
        }
    }
}
