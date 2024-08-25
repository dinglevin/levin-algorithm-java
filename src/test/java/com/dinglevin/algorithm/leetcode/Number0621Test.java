package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 描述：Number621Test
 *
 * @author dinglevin
 * @since 2021/6/17 20:26 周四
 */
public class Number0621Test {
    private Number0621 executor = new Number0621();

    @Test
    public void testVersion1() {
        char[] tasks = buildTasks("[\"A\",\"A\",\"A\",\"B\",\"B\",\"B\"]");
        assertEquals(8, executor.version1LeastInterval(tasks, 2));
        assertEquals(6, executor.version1LeastInterval(tasks, 0));

        tasks = buildTasks("[\"A\",\"A\",\"A\",\"A\",\"A\",\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"G\"]");
        assertEquals(16, executor.version1LeastInterval(tasks, 2));

        tasks = buildTasks("[\"A\",\"A\",\"A\",\"B\",\"B\",\"B\", \"C\",\"C\",\"C\", \"D\", \"D\", \"E\"]");
        assertEquals(12, executor.version1LeastInterval(tasks, 2));

        tasks = buildTasks("[\"A\",\"A\",\"A\",\"A\",\"A\",\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"G\"]");
        assertEquals(16, executor.version1LeastInterval(tasks, 2));
    }

    private char[] buildTasks(String tasks) {
        return JSON.parseObject(tasks, char[].class);
    }
}
