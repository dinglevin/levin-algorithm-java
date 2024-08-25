package com.dinglevin.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：Number621
 *
 * @author dinglevin
 * @since 2021/6/17 19:44 周四
 */
public class Number0621 {
    public int version1LeastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0 || n < 0) {
            return 0;
        }
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, TaskItem> taskMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            TaskItem taskItem = taskMap.get(tasks[i]);
            if (taskItem == null) {
                taskItem = new TaskItem(tasks[i], 0, 1);
                taskMap.put(tasks[i], taskItem);
            }
            taskItem.rest++;
        }

        TaskItem[] array = taskMap.values().toArray(new TaskItem[taskMap.size()]);
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time++;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < array.length; j++) {
                if (array[j].rest > 0) {
                    minNextValid = Math.min(minNextValid, array[j].nextValid);
                }
            }
            time = Math.max(minNextValid, time);

            int best = -1;
            for (int j = 0; j < array.length; j++) {
                if (array[j].rest != 0 && array[j].nextValid <= time) {
                    if (best == -1 || array[j].rest > array[best].rest) {
                        best = j;
                    }
                }
            }
            array[best].nextValid = time + n + 1;
            array[best].rest--;
        }

        return time;
    }

    private static class TaskItem {
        char task;
        int rest;
        int nextValid;

        public TaskItem(char task, int rest, int nextValid) {
            this.task = task;
            this.rest = rest;
            this.nextValid = nextValid;
        }
    }
}
