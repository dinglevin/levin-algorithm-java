package com.dinglevin.algorithm.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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
        Number0025.ListNode header = buildList("1,2,3,4,5,6");
        Number0025.ListNode result = executor.reverseKGroup(header, 4);

        System.out.println(toListString(result));
    }

    private Number0025.ListNode buildList(String list) {
        String[] items = StringUtils.split(list, ",");

        Number0025.ListNode header = null;
        Number0025.ListNode node = null;
        for (String item : items) {
            if (header == null) {
                header = new Number0025.ListNode(Integer.parseInt(item));
                node = header;
            } else {
                node.next = new Number0025.ListNode(Integer.parseInt(item));
                node = node.next;
            }
        }

        return header;
    }

    private String toListString(Number0025.ListNode node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append(",");
            node = node.next;
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
