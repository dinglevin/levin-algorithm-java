package com.dinglevin.algorithm.leetcode;

import java.util.Map;

/**
 * 描述：Number1277
 *
 * @author dinglevin
 * @since 2021/6/17 15:01 周四
 */
public class Number1277 {
    public int version2CountSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int total = 0;
        int row = matrix.length, column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i != 0 && j != 0 && matrix[i][j] != 0) {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
                }
                total += matrix[i][j];
            }
        }
        return total;
    }

    public int version1CountSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int total = 0;
        int row = matrix.length, column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                total++;
                int maxLen = 1;
                while (i + maxLen < row && j + maxLen < column) {
                    boolean matches = true;
                    for (int x = 0; x <= maxLen; x++) {
                        if (matrix[i + maxLen][j + x] == 0 || matrix[i + x][j + maxLen] == 0) {
                            matches = false;
                            break;
                        }
                    }
                    if (!matches) {
                        break;
                    }

                    total++;
                    maxLen++;
                }
            }
        }

        return total;
    }

    private void doCount(Map<Integer, Integer> countMap, int len) {
        Integer count = countMap.get(len);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        countMap.put(len, count);
    }
}
