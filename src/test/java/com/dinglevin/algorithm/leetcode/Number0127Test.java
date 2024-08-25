package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 描述：Number127Test
 *
 * @author dinglevin
 * @since 2021/6/17 17:21 周四
 */
public class Number0127Test {
    private Number0127 executor = new Number0127();

    @Test
    public void testVersion1() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        assertEquals(5, executor.version1LadderLength(beginWord, endWord, wordList));
    }

    @Test
    public void testVersion2() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        assertEquals(5, executor.version2LadderLength(beginWord, endWord, wordList));
    }

    @Test
    public void testVersion3() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        assertEquals(5, executor.version3LadderLength(beginWord, endWord, wordList));
    }
}
