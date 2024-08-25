package com.dinglevin.algorithm.others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 描述：FindLoadsTest
 *
 * @author dinglevin
 * @since 2021/7/11 20:30 周日
 */
public class FindLoadsTest {
    private FindRoads executor = new FindRoads();

    @Test
    public void testFindLoads() {
        assertEquals(6, executor.findAnswer(0, 3));
        assertEquals(20, executor.findAnswer(0, 5));
        assertEquals(0, executor.findAnswer(5, 6));
    }
}
