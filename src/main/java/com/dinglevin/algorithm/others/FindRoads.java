package com.dinglevin.algorithm.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：头条面试题
 *
 * 1.华东经济圈十个核心城市，编号0-9
 * 2.现修建高速公路串联十个城市，形成一个环路
 * 3.每个城市的出入口可上可下，但是只能开往编号临近的城市
 * 4.编写一个路径规划程序，求解汽车出发从X城市出发中途经过N个城市返回X的走法
 * 5.例如：从编号0出发，中途经过3个城市返回起点0，
 * 则走法6种(0-9-8-9-0，0-1-2-1-0，0-1-0-1-0，0-9-0-9-0，0-1-0-9-0，0-9-0-1-0)，
 * 没有走法，输出0
 * 6.输出以下两个testCase的结果，
 * a：从0号城市出发，途经5个城市的规划结果；
 * b.从5号城市出发，途经6个城市的规划结果。
 * 只需要输出多少种即可(一个数字)
 *
 * @author dinglevin
 * @since 2021/7/11 20:27 周日
 */
public class FindRoads {
    public int findAnswer(int start, int num) {
        if (num <= 0 || start >= 10) {
            return 0;
        }

        int result = 0;
        List<Integer> cities = new ArrayList<>();
        cities.add(start);
        result += innerFind(start, findLeftNext(start), num, cities);
        result += innerFind(start, findRightNext(start), num, cities);

        return result;
    }

    private int innerFind(int originStart, int curStep, int left, List<Integer> cities) {
        if (left == 0) {
            if (originStart == curStep) {
                print(cities);
                return 1;
            }
            return 0;
        }

        int result = 0;
        cities.add(curStep);
        result += innerFind(originStart, findLeftNext(curStep), left - 1, cities);
        result += innerFind(originStart, findRightNext(curStep), left - 1, cities);
        cities.remove(cities.size() - 1);

        return result;
    }

    private int findLeftNext(int start) {
        int result = start - 1;
        if (result < 0) {
            result = 9;
        }
        return result;
    }

    private int findRightNext(int start) {
        int result = start + 1;
        if (result > 9) {
            result = 0;
        }
        return result;
    }

    private void print(List<Integer> cities) {
        for (Integer i : cities) {
            System.out.print(i + "->");
        }
        System.out.println("0");
    }
}
