package com.dinglevin.algorithm.common;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.dinglevin.algorithm.leetcode.ListNode;
import com.google.common.collect.Lists;

public class ListNodeUtils {
    private ListNodeUtils() {
    }

    public static ListNode buildList(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        ListNode head = new ListNode(numbers[0]);
        ListNode tail = head;
        for (int i = 1; i < numbers.length; i++) {
            tail.setNext(new ListNode(numbers[i]));
            tail = tail.getNext();
        }
        return head;
    }

    public static ListNode buildList(String list) {
        String[] items = StringUtils.split(list, ",");
        if (items == null || items.length == 0) {
            return null;
        }

        ListNode head = new ListNode(Integer.parseInt(items[0]));
        ListNode tail = head;
        for (int i = 1; i < items.length; i++) {
            tail.setNext(new ListNode(Integer.parseInt(items[i])));
            tail = tail.getNext();
        }

        return head;
    }

    public static List<Integer> convertToList(ListNode list) {
        List<Integer> result = Lists.newArrayList();
        while (list != null) {
            result.add(list.getVal());
            list = list.getNext();
        }
        return result;
    }

    public static String toListString(ListNode head) {
        ListNode p = head;
        StringBuilder builder = new StringBuilder();
        while (p != null) {
            builder.append(p.getVal()).append(",");
            p = p.getNext();
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void printList(ListNode header) {
        ListNode node = header;
        while (node != null) {
            System.out.print(node.getVal() + " -> ");
            node = node.getNext();
        }
        System.out.println();
    }
}
