package com.dinglevin.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 七个不同的符号代表罗马数字，其值如下：
 * 符号 值
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 * 
 * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减
 * 1 (I)：IX。
 * 仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。
 * 如果需要将符号附加4次，请使用 减法形式。
 * 
 * 给定一个整数，将其转换为罗马数字。
 * 示例 1：
 * 输入：num = 3749
 * 输出： "MMMDCCXLIX"
 * 
 * 解释：
 * 3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
 * 700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
 * 40 = XL 由于 50 (L) 减 10 (X)
 * 9 = IX 由于 10 (X) 减 1 (I)
 * 注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
 * 
 * 示例 2：
 * 输入：num = 58
 * 输出："LVIII"
 * 
 * 解释：
 * 50 = L
 * 8 = VIII
 * 
 * 示例 3：
 * 输入：num = 1994
 * 输出："MCMXCIV"
 * 
 * 解释：
 * 1000 = M
 * 900 = CM
 * 90 = XC
 * 4 = IV
 * 
 * 提示：
 * 1 <= num <= 3999
 * 
 * @author dinglevin
 * @since 2024-09-12 23:20:30
 */
public class Number0012 {
    public String intToRoman(int num) {
        return new Version1().invoke(num);
    }

    public static class Version1 {
        private static final Map<Integer, String> map = new HashMap<>();
        static {
            map.put(1, "I");
            map.put(2, "II");
            map.put(3, "III");
            map.put(4, "IV");
            map.put(5, "V");
            map.put(6, "VI");
            map.put(7, "VII");
            map.put(8, "VIII");
            map.put(9, "IX");
            map.put(10, "X");
            map.put(20, "XX");
            map.put(30, "XXX");
            map.put(40, "XL");
            map.put(50, "L");
            map.put(60, "LX");
            map.put(70, "LXX");
            map.put(80, "LXXX");
            map.put(90, "XC");
            map.put(100, "C");
            map.put(200, "CC");
            map.put(300, "CCC");
            map.put(400, "CD");
            map.put(500, "D");
            map.put(600, "DC");
            map.put(700, "DCC");
            map.put(800, "DCCC");
            map.put(900, "CM");
            map.put(1000, "M");
            map.put(2000, "MM");
            map.put(3000, "MMM");
        }

        public String invoke(int num) {
            if (num < 1) {
                return "";
            }

            StringBuilder builder = new StringBuilder();
            int p = num / 1000;
            if (p > 0) {
                builder.append(map.get(p * 1000));
            }
            p = (num % 1000) / 100;
            if (p > 0) {
                builder.append(map.get(p * 100));
            }
            p = (num % 100) / 10;
            if (p > 0) {
                builder.append(map.get(p * 10));
            }
            p = num % 10;
            if (p > 0) {
                builder.append(map.get(p));
            }

            return builder.toString();
        }
    }

    public static class Version2 {
        private static final int[] values = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        private static final String[] symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
                "V", "IV", "I" };

        public String invoke(int num) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < values.length && num > 0; i++) {
                while (num >= values[i]) {
                    num -= values[i];
                    builder.append(symbols[i]);
                }
            }

            return builder.toString();
        }
    }
}
