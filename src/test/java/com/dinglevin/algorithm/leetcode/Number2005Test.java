package com.dinglevin.algorithm.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 描述：Number2005Test
 *
 * @author dinglevin
 * @since 2021/6/15 20:03 周二
 */
public class Number2005Test {
    private Number2005 executor = new Number2005();

    @Test
    public void doTest() {
        System.out.println(executor.isStraight(parseInput("11,10,8,0,12")));
    }

    private int[] parseInput(String input) {
        String[] chars = StringUtils.split(input, ",");
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = Integer.parseInt(chars[i]);
        }
        return result;
    }
}

