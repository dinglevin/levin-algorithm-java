package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Number0017Test {
    @Test
    public void testVersion1() {
        assertEquals(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"), 
            new Number0017.Version1().invoke("23"));
        assertEquals(Arrays.asList("a","b","c"), new Number0017.Version1().invoke("2"));
        assertEquals(Arrays.asList(), new Number0017.Version1().invoke(""));
    }

    @Test
    public void testVersion2() {
        assertEquals(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"), 
            new Number0017.Version2().invoke("23"));
        assertEquals(Arrays.asList("a","b","c"), new Number0017.Version2().invoke("2"));
        assertEquals(Arrays.asList(), new Number0017.Version2().invoke(""));
    }
}
