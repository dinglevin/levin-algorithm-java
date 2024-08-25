package com.dinglevin.algorithm.leetcode;

import java.util.Stack;

/**
 * 来源：https://leetcode-cn.com/problems/min-stack/
 * 
 * @author dinglevin
 * @since 2021/6/13 15:05 周日
 */
public class Number0115 {
    private MinStack stack = new MinStack();

    public void push(int value) {
        stack.push(value);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.top();
    }

    public int getMin() {
        return stack.getMin();
    }

    public static class MinStack {
        private Stack<Integer> inStack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            inStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            inStack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            if (inStack.isEmpty()) {
                throw new RuntimeException("stack empty");
            }

            inStack.pop();
            minStack.pop();
        }

        public int top() {
            if (inStack.isEmpty()) {
                throw new RuntimeException("stack empty");
            }
            return inStack.peek();
        }

        public int getMin() {
            if (inStack.isEmpty()) {
                throw new RuntimeException("stack empty");
            }
            return minStack.peek();
        }
    }
}
