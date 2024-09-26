package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Number0022Test {
    @Test
    public void testVersion1() {
        assertEquals(Arrays.asList("()"), new Number0022.Version1().invoke(1));
        assertEquals(Arrays.asList("(())","()()"), new Number0022.Version1().invoke(2));
        assertEquals(Arrays.asList("((()))","(()())","(())()","()(())","()()()"), new Number0022.Version1().invoke(3));
    }
    
    @Test
    public void testVersion2() {
        assertEquals(Arrays.asList("()"), new Number0022.Version2().invoke(1));
        assertEquals(Arrays.asList("(())","()()"), new Number0022.Version2().invoke(2));
        assertEquals(Arrays.asList("((()))","(()())","(())()","()(())","()()()"), new Number0022.Version2().invoke(3));
    }
}
