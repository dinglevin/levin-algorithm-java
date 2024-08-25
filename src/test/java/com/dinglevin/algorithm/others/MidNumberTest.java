package com.dinglevin.algorithm.others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * 描述：MidNumberTest
 *
 * @author dinglevin
 * @since 2021/6/20 17:01 周日
 */
public class MidNumberTest {
    private MidNumber executor = new MidNumber();

    @Test
    public void testVersion1FindMidNum() {
        int[] array = new int[] { 8, 7, 10, 14, 20, 17, 9, 26, 28, 30 };
        assertEquals(Lists.newArrayList(26, 28, 30), executor.version1FindMidNum(array));
    }
}
