package com.dinglevin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 
 * @author dinglevin
 * @since 2024-09-25 22:55:26
 */
public class Number0022 {
    public List<String> generateParenthesis(int n) {
        return new Version2().invoke(n);
    }

    public static class Version1 {
        public List<String> invoke(int n) {
            char[] chars = new char[n * 2];
            List<String> result = new ArrayList<String>();
            generateAll(result, chars, 0, n * 2);
            return result;
        }

        private void generateAll(List<String> result, char[] chars, int pos, int max) {
            if (pos == max) {
                if (isValid(chars)) {
                    result.add(new String(chars));
                }
                return;
            }

            chars[pos] = '(';
            generateAll(result, chars, pos + 1, max);
            chars[pos] = ')';
            generateAll(result, chars, pos + 1, max);
        }

        private boolean isValid(char[] chars) {
            int count = 0;
            for (char c : chars) {
                if (c == '(') {
                    count++;
                } else if (c == ')') {
                    count--;
                }
                if (count < 0) {
                    return false;
                }
            }
            return count == 0;
        }
    }

    public static class Version2 {
        public List<String> invoke(int n) {
            List<String> result = new ArrayList<String>();
            backtrack(result, new StringBuilder(), 0, 0, n);
            return result;
        }

        private void backtrack(List<String> result, StringBuilder builder, int open, int close, int n) {
            if (builder.length() == n * 2) {
                result.add(builder.toString());
                return;
            }

            if (open < n) {
                builder.append('(');
                backtrack(result, builder, open + 1, close, n);
                builder.deleteCharAt(builder.length() - 1);
            }
            if (open > close) {
                builder.append(')');
                backtrack(result, builder, open, close + 1, n);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
