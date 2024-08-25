package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 描述：Number115Test
 *
 * @author dinglevin
 * @since 2021/6/13 15:19 周日
 */
public class Number0115Test {
    @Test
    public void testDoubleStack() {
        Number0115.MinStack minStack = new Number0115.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int result = minStack.getMin();
        assertEquals(-3, result);

        minStack.pop();
        result = minStack.top();
        assertEquals(0, result);

        result = minStack.getMin();
        assertEquals(-2, result);
    }
}
