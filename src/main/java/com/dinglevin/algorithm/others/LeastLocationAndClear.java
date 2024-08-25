package com.dinglevin.algorithm.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：LeastLocationAndClear
 *
 * @author dinglevin
 * @since 2021/6/29 14:06 周二
 */
public class LeastLocationAndClear {
    public List<Integer> version2Choose(int[] inventories, int target) {
        if (inventories == null || inventories.length == 0 || target == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        for (; i < inventories.length; i++) {
            if (inventories[i] <= 0) {
                continue;
            }
            if (target < inventories[i]) {
                break;
            }
            target -= inventories[i];
            result.add(i);
        }
        if (target == 0) {
            return result;
        }

        int start = i;
        for (; i < inventories.length; i++) {
            if (inventories[i] <= 0) {
                continue;
            }
            if (target == inventories[i]) {
                result.add(i);
                target -= inventories[i];
            }
        }
        if (target != 0) {
            result.add(start);
        }
        return result;
    }

    public List<Integer> version1Choose(int[] inventories, int target) {
        if (inventories == null || inventories.length == 0 || target == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int minLocations = findMinLocations(inventories, target);
        if (minLocations == inventories.length) {
            for (int i = 0; i < minLocations; i++) {
                result.add(i);
            }
            return result;
        }
        if (minLocations == 1) {
            result.add(0);
            return result;
        }

        innerChoose(inventories, inventories.length - 1, target, minLocations, result);
        return result;
    }

    private boolean innerChoose(int[] inventories, int start, int left, int minLocations, List<Integer> result) {
        for (int i = start; i >= 0; i--) {
            if (inventories[i] <= 0) {
                continue;
            }

            result.add(i);
            if ((i == 0 && inventories[i] > left && minLocations == 1) ||
                    (inventories[i] == left && minLocations == 1)) {
                return true;
            }

            if (inventories[i] < left && minLocations == 1) {
                result.remove((Integer) i);
                return false;
            }
            if (innerChoose(inventories, i - 1,left - inventories[i], minLocations - 1, result)) {
                return true;
            }
            result.remove((Integer) i);
        }
        return false;
    }

    private int findMinLocations(int[] inventories, int target) {
        int minLocation = 0;
        for (int i = 0; i < inventories.length; i++) {
            target -= inventories[i];
            minLocation++;
            if (target <= 0) {
                break;
            }
        }
        return minLocation;
    }
}
