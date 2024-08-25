package com.dinglevin.algorithm.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：查找中数
 *
 * 有一个无序数组，如8, 7, 10, 14, 20, 17, 9, 26, 28, 30，
 * 如果一个数的左边序列都小于它，右边序列都大于它，那么我们这个数为 `中数`，找出所有中数，
 * 要求时间复杂度O(N)，空间复杂度不超过O(N)
 *
 * 参考：https://blog.csdn.net/u013677156/article/details/37904319
 *
 * @author dinglevin
 * @since 2021/6/20 16:50 周日
 */
public class MidNumber {
    public List<Integer> version1FindMidNum(int[] array) {
        List<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }

        int len = array.length;
        int max = Integer.MIN_VALUE;
        int[] min = new int[len];

        min[len - 1] = array[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (array[i] < min[i + 1]) {
                min[i] = array[i];
            } else {
                min[i] = min[i + 1];
            }
        }

        for (int i = 0; i < len; i++) {
            int value = array[i];
            if (value > max && (i == len - 1 || value < min[i + 1])) {
                result.add(value);
            }
            if (value > max) {
                max = value;
            }
        }

        return result;
    }
}
