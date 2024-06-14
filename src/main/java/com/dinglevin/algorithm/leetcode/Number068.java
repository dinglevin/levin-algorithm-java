package com.dinglevin.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 问题描述:
 * 文本左右对齐
 * 1、给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 2、你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 3、要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 4、文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 * 1、单词是指由非空格字符组成的字符序列。
 * 2、每个单词的长度大于 0，小于等于 maxWidth。
 * 3、输入单词数组 words 至少包含一个单词。
 *
 * @author dinglevin
 * @since 2024/6/3 16:40
 */
public class Number68 {
    public static void main(String[] args) {
        String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth));
    }

    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = Lists.newArrayList();

        int index = 0;
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < words.length && (totalChars + words[last].length() + 1) <= maxWidth) {
                totalChars += (words[last].length() + 1);
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numOfWords = last - index;
            int numOfSpaces = maxWidth - totalChars + numOfWords - 1;

            if (last == words.length || numOfWords == 1) {
                for (int i = 0; i < numOfWords; i++) {
                    line.append(words[i + index]);
                    if (i != numOfWords - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spaceBetweenWords = numOfSpaces / (numOfWords - 1);
                int extraSpaces = numOfSpaces % (numOfWords - 1);
                for (int i = 0; i < numOfWords; i++) {
                    line.append(words[i + index]);
                    if (i < numOfWords - 1) {
                        int spacesToApply = spaceBetweenWords + (i < extraSpaces ? 1 : 0);
                        for (int j = 0; j < spacesToApply; j++) {
                            line.append(" ");
                        }
                    }
                }
            }

            lines.add(line.toString());
            index = last;
        }

        return lines;
    }
}
