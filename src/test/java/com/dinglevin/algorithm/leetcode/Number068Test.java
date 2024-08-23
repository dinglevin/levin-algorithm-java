package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class Number068Test {
    @Test
    public void testFullJustify() {
        List<String> actualList = new Number068.Version1().invoke(
                new String[] { "This", "is", "an", "example", "of", "text", "justification." },
                16);
        List<String> expectedList = Lists.newArrayList(
                "This    is    an",
                "example  of text",
                "justification.  ");

        assertEquals(expectedList, actualList);
    }
}
