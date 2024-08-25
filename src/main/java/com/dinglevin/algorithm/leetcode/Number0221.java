package com.dinglevin.algorithm.leetcode;

/**
 * 描述：Number221
 *
 * @author dinglevin
 * @since 2021/6/15 19:21 周二
 */
public class Number0221 {
    public int maximalSquare(char[][] matrix) {
        return version1(matrix);
    }

    protected int version2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxLen = 0;
        int row = matrix.length, column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int cell = matrix[i][j] == '1' ? 1 : 0;
                if (i == 0 || j == 0) {
                    dp[i][j] = cell;
                } else if (cell == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
                }

                maxLen = Math.max(dp[i][j], maxLen);
            }
        }

        return maxLen * maxLen;
    }

    private static int min(int v1, int v2, int v3) {
        int min = Math.min(v1, v2);
        return Math.min(min, v3);
    }

    /**
     * 暴力解法
     * @param matrix
     * @return
     */
    protected int version1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxLen = 0;
        int row = matrix.length, column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                int curLen = 1;
                while (i + curLen < matrix.length && j + curLen < matrix[i].length) {
                    boolean matches = true;
                    for (int x = 0; x <= curLen; x++) {
                        if (matrix[i + curLen][j + x] == '0' || matrix[i + x][j + curLen] == '0') {
                            matches = false;
                            break;
                        }
                    }
                    if (!matches) {
                        break;
                    }
                    curLen++;
                }

                if (maxLen < curLen) {
                    maxLen = curLen;
                }
            }
        }

        return maxLen * maxLen;
    }
}
