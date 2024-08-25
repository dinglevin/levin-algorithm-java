package com.dinglevin.algorithm.others;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

/**
 * 描述：ConsistencyHashTest
 *
 * @author dinglevin
 * @since 2021/6/7 18:10 周一
 */
public class ConsistencyHashTest {
    @Test
    public void testSimple() {
        List<String> nodeList = Lists.newArrayList();
        IntStream.range(0, 10).forEach(index -> nodeList.add("192.168.1." + (index + 2)));

        ConsistencyHash consistencyHash = new ConsistencyHash(nodeList);
        Multimap<String, Integer> allocatedMap = ArrayListMultimap.create();
        IntStream.range(0, 3000).forEach(value -> {
            String node = consistencyHash.getPrimaryNode("" + value);
            allocatedMap.put(node, value);
        });

        List<String> nodeList2 = Lists.newArrayList(nodeList);
        nodeList2.remove(5);
        ConsistencyHash consistencyHash2 = new ConsistencyHash(nodeList2);
        Multimap<String, Integer> allocatedMap2 = ArrayListMultimap.create();
        IntStream.range(0, 3000).forEach(value -> {
            String node = consistencyHash2.getPrimaryNode("" + value);
            allocatedMap2.put(node, value);
        });

        for (String node : nodeList) {
            Collection<Integer> firstList = allocatedMap.get(node);
            Collection<Integer> secondList = allocatedMap2.get(node);
            System.out.println(node + ": ");
            System.out.println(">>>>" + firstList);
            System.out.println(">>>>" + secondList);
            System.out.println("<<<<" + notInSecond(firstList, secondList));
            System.out.println("<<<<" + notInSecond(secondList, firstList));
            System.out.println();
        }
    }

    private List<Integer> notInSecond(Collection<Integer> firstList, Collection<Integer> secondList) {
        List<Integer> result = Lists.newArrayList();
        for (Integer value : firstList) {
            if (!secondList.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }
}