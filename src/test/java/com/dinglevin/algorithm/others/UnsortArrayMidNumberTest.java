package com.dinglevin.algorithm.others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 描述：UnsortArrayMidNumberTest
 *
 * @author dinglevin
 * @since 2021/6/20 16:40 周日
 */
public class UnsortArrayMidNumberTest {
    private UnsortArrayMidNumber executor = new UnsortArrayMidNumber();

    @Test
    public void testVersion1FindMidNum() {
        int[] array = new int[] { 8, 7, 10, 14, 20, 17, 9, 26, 28, 30 };
        assertEquals(14, executor.version1FindMidNum(array));
    }
}
