package com.dinglevin.algorithm.leetcode;

/**
 * 描述：Number1689
 *
 * @author dinglevin
 * @since 2021/6/13 10:56 周日
 */
public class Number1689 {
    public int version1(String n) {
        int result = 0;

        int[] array = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            array[i] = (int)n.charAt(i) - 48;
        }

        boolean allZero = false;
        while (!allZero) {
            allZero = true;

            StringBuilder builder = new StringBuilder();
            boolean canStart = false;
            for (int i = 0; i < n.length(); i++) {
                if (!canStart && array[i] == 0) {
                    continue;
                }

                canStart = true;
                if (array[i] > 0) {
                    allZero = false;
                    array[i] -= 1;
                    builder.append("1");
                } else {
                    builder.append("0");
                }
            }

            if (!allZero) {
                result++;
                System.out.print(builder + " + ");
            }
        }

        return result;
    }

    public int version2(String n) {
        int result = 0;

        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            int cur = (int)n.charAt(i) - 48;
            if (cur > sum) {
                int delta = cur - sum;
                result += delta;
                sum += delta;
            }
        }

        return result;
    }

    public int version3(String n) {
        int result = 0;

        for (int i = 0; i < n.length(); i++) {
            result = Math.max((int)n.charAt(i) - 48, result);
        }

        return result;
    }
}
