package com.dinglevin.algorithm.others;

import java.util.PriorityQueue;

/**
 * 描述：无序数组中位数查找
 * 参考：https://www.cnblogs.com/shizhh/p/5746151.html
 *
 * @author dinglevin
 * @since 2021/6/20 16:31 周日
 */
public class UnsortArrayMidNumber {
    public int version1FindMidNum(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException();
        }

        int len = array.length;
        int heapSize = len / 2 + 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            queue.add(array[i]);
        }

        for (int i = heapSize; i < len; i++) {
            if (queue.peek() < array[i]) {
                queue.poll();
                queue.add(array[i]);
            }
        }

        return queue.peek();
    }
}
