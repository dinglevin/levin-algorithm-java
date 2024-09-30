package com.dinglevin.algorithm.leetcode;

import static com.dinglevin.algorithm.common.ListNodeUtils.buildList;
import static com.dinglevin.algorithm.common.ListNodeUtils.toListString;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number0024Test {
    @Test
    public void testVersion1() {
        assertEquals("2,1,4,3", toListString(new Number0024.Version1().invoke(buildList("1,2,3,4"))));
        assertEquals("2,1,4,3,5", toListString(new Number0024.Version1().invoke(buildList("1,2,3,4,5"))));
    }
}
