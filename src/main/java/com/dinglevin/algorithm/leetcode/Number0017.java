package com.dinglevin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 1 -> []
 * 2 -> [abc]
 * 3 -> [def]
 * 4 -> [ghi]
 * 5 -> [jkl]
 * 6 -> [mno]
 * 7 -> [pqrs]
 * 8 -> [tuv]
 * 9 -> [wxyz]
 * 
 * 示例 1:
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 
 * @author dinglevin
 * @since 2024-09-21 14:41:59
 */
public class Number0017 {
    public List<String> letterCombinations(String digits) {
        return new Version1().invoke(digits);
    }

    public static class Version1 {
        private static final Map<Character, String> MAPPING = new HashMap<>();
        static {
            MAPPING.put('2', "abc");
            MAPPING.put('3', "def");
            MAPPING.put('4', "ghi");
            MAPPING.put('5', "jkl");
            MAPPING.put('6', "mno");
            MAPPING.put('7', "pqrs");
            MAPPING.put('8', "tuv");
            MAPPING.put('9', "wxyz");
        }

        public List<String> invoke(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.isEmpty()) {
                return result;
            }

            backtrack(result, digits, 0, new StringBuilder());
            return result;
        }

        private void backtrack(List<String> result, String digits, int index, StringBuilder curLine) {
            if (curLine.length() == digits.length()) {
                result.add(curLine.toString());
            } else {
                String curChars = MAPPING.get(digits.charAt(index));
                for (int i = 0; i < curChars.length(); i++) {
                    curLine.append(curChars.charAt(i));
                    backtrack(result, digits, index + 1, curLine);
                    curLine.deleteCharAt(index);
                }
            }
        }
    }

    public static class Version2 {
        private static final Map<Character, String> MAPPING = new HashMap<>();
        static {
            MAPPING.put('2', "abc");
            MAPPING.put('3', "def");
            MAPPING.put('4', "ghi");
            MAPPING.put('5', "jkl");
            MAPPING.put('6', "mno");
            MAPPING.put('7', "pqrs");
            MAPPING.put('8', "tuv");
            MAPPING.put('9', "wxyz");
        }

        public List<String> invoke(String digits) {
            if (digits.isEmpty()) {
                return new ArrayList<String>();
            }

            Queue<String> queue = new LinkedList<>();
            queue.add("");
            for (int i = 0; i < digits.length(); i++) {
                String letters = MAPPING.get(digits.charAt(i));
                int n = queue.size();
                for (int j = 0; j < n; j++) {
                    String curLine = queue.poll();
                    for (char letter : letters.toCharArray()) {
                        queue.add(curLine + letter);
                    }
                }
            }

            return new ArrayList<>(queue);
        }
    }
}
