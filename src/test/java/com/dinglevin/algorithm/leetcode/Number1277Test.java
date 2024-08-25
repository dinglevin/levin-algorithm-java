package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 描述：Number1277Test
 *
 * @author dinglevin
 * @since 2021/6/17 15:09 周四
 */
public class Number1277Test {
    private Number1277 executor = new Number1277();

    @Test
    public void testVersion1() {
        int[][] matrix = buildMatrix("[\n" +
                "  [0,1,1,1],\n" +
                "  [1,1,1,1],\n" +
                "  [0,1,1,1]\n" +
                "]");
        assertEquals(15, executor.version1CountSquares(matrix));
    }

    @Test
    public void testVersion2() {
        int[][] matrix = buildMatrix("[\n" +
                "  [0,1,1,1],\n" +
                "  [1,1,1,1],\n" +
                "  [0,1,1,1]\n" +
                "]");
        assertEquals(15, executor.version2CountSquares(matrix));
    }

    private int[][] buildMatrix(String matrix) {
        return JSON.parseObject(matrix, int[][].class);
    }
}