package com.dinglevin.algorithm.leetcode;

import static com.dinglevin.algorithm.common.ListNodeUtils.convertToList;
import static com.dinglevin.algorithm.common.ListNodeUtils.buildList;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.dinglevin.algorithm.model.ListNode;

/**
 * 描述：Number92Test
 *
 * @author dinglevin
 * @since 2021/6/20 18:17 周日
 */
public class Number0092Test {
    private Number0092 executor = new Number0092();

    @Test
    public void testReverseBetween() {
        ListNode head = buildList(new int[] { 1, 2, 3, 4, 5 });
        // assertEquals(Arrays.asList(1, 4, 3, 2, 5),
        // toIntArray(executor.reverseBetween(head, 2, 4)));

        head = buildList(new int[] { 3, 5 });
        // assertEquals(Arrays.asList(5, 3), toIntArray(executor.reverseBetween(head, 1,
        // 2)));

        head = buildList(new int[] { 3, 5 });
        assertEquals(Arrays.asList(3, 5), convertToList(executor.reverseBetween(head, 1, 1)));
    }
}
