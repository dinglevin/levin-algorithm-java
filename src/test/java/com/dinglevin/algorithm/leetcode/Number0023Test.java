package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.dinglevin.algorithm.leetcode.Number0023.ListNode;

public class Number0023Test {
    @Test
    public void testVersion1() {
        assertEquals(Arrays.asList(1,1,2,3,4,4,5,6), convert(new Number0023.Version1().invoke(new ListNode[] { 
            create(Arrays.asList(1,4,5)),
            create(Arrays.asList(1,3,4)),
            create(Arrays.asList(2,6))
        })));
        assertEquals(Arrays.asList(), convert(new Number0023.Version1().invoke(new ListNode[0])));
        assertEquals(Arrays.asList(), convert(new Number0023.Version1().invoke(new ListNode[] {
            create(Arrays.asList())
        })));
    }

    @Test
    public void testVersion2() {
        assertEquals(Arrays.asList(1,1,2,3,4,4,5,6), convert(new Number0023.Version2().invoke(new ListNode[] { 
            create(Arrays.asList(1,4,5)),
            create(Arrays.asList(1,3,4)),
            create(Arrays.asList(2,6))
        })));
        assertEquals(Arrays.asList(), convert(new Number0023.Version2().invoke(new ListNode[0])));
        assertEquals(Arrays.asList(), convert(new Number0023.Version2().invoke(new ListNode[] {
            create(Arrays.asList())
        })));
    }

    @Test
    public void testVersion3() {
        assertEquals(Arrays.asList(1,1,2,3,4,4,5,6), convert(new Number0023.Version3().invoke(new ListNode[] { 
            create(Arrays.asList(1,4,5)),
            create(Arrays.asList(1,3,4)),
            create(Arrays.asList(2,6))
        })));
        assertEquals(Arrays.asList(), convert(new Number0023.Version3().invoke(new ListNode[0])));
        assertEquals(Arrays.asList(), convert(new Number0023.Version3().invoke(new ListNode[] {
            create(Arrays.asList())
        })));
    }

    @Test
    public void testVersion4() {
        assertEquals(Arrays.asList(1,1,2,3,4,4,5,6), convert(new Number0023.Version4().invoke(new ListNode[] { 
            create(Arrays.asList(1,4,5)),
            create(Arrays.asList(1,3,4)),
            create(Arrays.asList(2,6))
        })));
        assertEquals(Arrays.asList(), convert(new Number0023.Version4().invoke(new ListNode[0])));
        assertEquals(Arrays.asList(), convert(new Number0023.Version4().invoke(new ListNode[] {
            create(Arrays.asList())
        })));
    }

    private ListNode create(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return null;
        }

        ListNode head = new ListNode(nums.get(0));
        ListNode p = head;
        for (int i = 1; i < nums.size(); i++) {
            p.next = new ListNode(nums.get(i));
            p = p.next;
        }
        return head;
    }

    private List<Integer> convert(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            result.add(p.val);
            p = p.next;
        }
        return result;
    }
}
