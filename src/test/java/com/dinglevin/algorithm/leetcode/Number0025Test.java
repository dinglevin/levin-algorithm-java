package com.dinglevin.algorithm.leetcode;

import static com.dinglevin.algorithm.common.ListNodeUtils.buildList;
import static com.dinglevin.algorithm.common.ListNodeUtils.toListString;

import org.junit.Test;

import com.dinglevin.algorithm.model.ListNode;

/**
 * 描述：Number25Test
 *
 * @author dinglevin
 * @since 2021/6/15 11:35 周二
 */
public class Number0025Test {
    private Number0025 executor = new Number0025();

    @Test
    public void testReverseKGroup() {
        ListNode header = buildList("1,2,3,4,5,6");
        ListNode result = executor.reverseKGroup(header, 4);

        System.out.println(toListString(result));
    }
}
