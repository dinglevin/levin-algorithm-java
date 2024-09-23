package com.dinglevin.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 
 * @author dinglevin
 * @since 2024-09-23 23:47:45
 */
public class Number0020 {
    public boolean isValid(String s) {
        return new Version1().invoke(s);
    }

    public static class Version1 {
        private static final Map<Character, Character> MAPPING = new HashMap<>();
        static {
            MAPPING.put('(', ')');
            MAPPING.put('{', '}');
            MAPPING.put('[', ']');
        }

        public boolean invoke(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            if (s.length() % 2 != 0) {
                return false;
            }

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (MAPPING.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char popped = stack.pop();
                    if (MAPPING.get(popped) != null && MAPPING.get(popped) != c) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }

    public static class Version2 {
        private static final Map<Character, Character> MAPPING = new HashMap<>();
        static {
            MAPPING.put(')', '(');
            MAPPING.put('}', '{');
            MAPPING.put(']', '[');
        }

        public boolean invoke(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            if (s.length() % 2 != 0) {
                return false;
            }

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (MAPPING.containsKey(c)) {
                    if (stack.isEmpty() || stack.pop() != MAPPING.get(c)) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }
    }
}
