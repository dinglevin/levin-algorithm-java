package com.dinglevin.algorithm.leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * 
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 * 
 * @author dinglevin
 * @since 2024-08-29 23:07
 */
public class Number0007 {
    public int reverse(int x) {
        return new Version1().invoke(x);
    }

    public static class Version1 {
        public int invoke(int x) {
            int result = 0;
            int sign = x < 0 ? -1 : 1;
            while (x != 0) {
                int temp = sign * (x % 10);
                if (sign == 1 && result > (Integer.MAX_VALUE - temp) / 10) {
                    return 0;
                }
                if (sign == -1 && -result < (Integer.MIN_VALUE + temp) / 10) {
                    return 0;
                }
                x /= 10;
                result = result * 10 + temp;
            }

            return sign * result;
        }
    }

    public static class Version2 {
        public int invoke(int x) {
            String str = Integer.toString(Math.abs(x));
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                char c = chars[i];
                chars[i] = chars[chars.length - i - 1];
                chars[chars.length - i - 1] = c;
            }

            StringBuilder builder = new StringBuilder();
            if (x < 0) {
                builder.append('-');
            }
            builder.append(chars);

            try {
                return Integer.parseInt(builder.toString(), 10);
            } catch (Exception ex) {
                return 0;
            }
        }
    }

    public static class Version3 {
        public int invoke(int x) {
            int rev = 0;
            while (x != 0) {
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }
    }
}
