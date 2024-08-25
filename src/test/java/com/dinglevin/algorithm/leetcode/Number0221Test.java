package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 描述：Number221Test
 *
 * @author dinglevin
 * @since 2021/6/17 11:46 周四
 */
public class Number0221Test {
    private Number0221 executor = new Number0221();

    @Test
    public void testVersion1() {
        char[][] matrix = buildMatrix("[[\"1\",\"0\",\"1\",\"0\",\"0\"]," +
                "[\"1\",\"0\",\"1\",\"1\",\"1\"]," +
                "[\"1\",\"1\",\"1\",\"1\",\"1\"]," +
                "[\"1\",\"0\",\"0\",\"1\",\"0\"]]");
        assertEquals(4, executor.version1(matrix));
    }

    @Test
    public void testVersion2() {
        char[][] matrix = buildMatrix("[[\"1\",\"0\",\"1\",\"0\",\"0\"]," +
                "[\"1\",\"0\",\"1\",\"1\",\"1\"]," +
                "[\"1\",\"1\",\"1\",\"1\",\"1\"]," +
                "[\"1\",\"0\",\"0\",\"1\",\"0\"]]");
        assertEquals(4, executor.version2(matrix));
    }

    private char[][] buildMatrix(String matrix) {
        return JSON.parseObject(matrix, char[][].class);
    }
}
