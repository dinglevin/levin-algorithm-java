package com.dinglevin.algorithm.leetcode;

/**
 * 29. 两数相除
 * TODO 未实现
 * 
 * @author dinglevin
 * @since 2024-10-10 23:50:27
 */
public class Number0029 {
    public int divide(int dividend, int divisor) {
        return new Version1().invoke(dividend, divisor);
    }

    public static class Version1 {
        public int invoke(int dividend, int divisor) {
            long result = 1;
            long p = Math.abs((long) dividend);
            long q = Math.abs((long) divisor);
            while (p >= q) {
                q += q;
                result <<= 1;
            }
            if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
                return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
            }
            return -result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) -result;
        }
    }
}
