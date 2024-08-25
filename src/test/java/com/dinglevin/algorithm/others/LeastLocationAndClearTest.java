package com.dinglevin.algorithm.others;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * 描述：LeastLocationAndClearTest
 *
 * @author dinglevin
 * @since 2021/6/29 14:58 周二
 */
public class LeastLocationAndClearTest {
    private LeastLocationAndClear executor = new LeastLocationAndClear();

    @Test
    public void testVersion1Choose() {
        int[] inventories = new int[] { 5,4,3,2,1 };
        List<Integer> result = executor.version1Choose(inventories, 10);
        Collections.sort(result);
        assertEquals(Arrays.asList(0, 1, 4), result);

        inventories = new int[] { 10,10,3,2,1 };
        result = executor.version1Choose(inventories, 7);
        Collections.sort(result);
        assertEquals(Arrays.asList(0), result);

        inventories = new int[] { 10,10,3,2,1 };
        result = executor.version1Choose(inventories, 14);
        Collections.sort(result);
        assertEquals(Arrays.asList(0, 1), result);
    }

    @Test
    public void testVersion2Choose() {
        int[] inventories = new int[] { 5,4,3,2,1 };
        List<Integer> result = executor.version2Choose(inventories, 10);
        Collections.sort(result);
        assertEquals(Arrays.asList(0, 1, 4), result);

        inventories = new int[] { 10,10,3,2,1 };
        result = executor.version2Choose(inventories, 7);
        Collections.sort(result);
        assertEquals(Arrays.asList(0), result);

        inventories = new int[] { 10,10,3,2,1 };
        result = executor.version2Choose(inventories, 14);
        Collections.sort(result);
        assertEquals(Arrays.asList(0, 1), result);
    }
}
