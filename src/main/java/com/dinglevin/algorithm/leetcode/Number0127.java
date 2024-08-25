package com.dinglevin.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 描述：Number127
 *
 * @author dinglevin
 * @since 2021/6/17 15:55 周四
 */
public class Number0127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return version3LadderLength(beginWord, endWord, wordList);
    }

    public int version3LadderLength(String beginWord, String endWord, List<String> wordList) {
        if (isEmpty(beginWord) || isEmpty(endWord) || isEmpty(wordList)) {
            return 0;
        }

        Map<String, Integer> wordIdMap = new HashMap<>();
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        v2AddWordAndEdges(wordIdMap, edgeMap, beginWord);
        for (String word : wordList) {
            v2AddWordAndEdges(wordIdMap, edgeMap, word);
        }
        if (!wordIdMap.containsKey(endWord)) {
            return 0;
        }

        Integer beginId = wordIdMap.get(beginWord);
        Integer endId = wordIdMap.get(endWord);

        Queue<Integer> queueBegin = new LinkedList<>();
        queueBegin.offer(beginId);
        int[] distanceBegin = new int[v2NodeNum];
        Arrays.fill(distanceBegin, -1);
        distanceBegin[beginId] = 0;

        Queue<Integer> queueEnd = new LinkedList<>();
        queueEnd.offer(endId);
        int[] distanceEnd = new int[v2NodeNum];
        Arrays.fill(distanceEnd, -1);
        distanceEnd[endId] = 0;

        while (!queueBegin.isEmpty() || !queueEnd.isEmpty()) {
            int beginSize = queueBegin.size();
            for (int i = 0; i < beginSize; i++) {
                Integer wordId = queueBegin.poll();
                if (distanceEnd[wordId] != -1) {
                    return (distanceBegin[wordId] + distanceEnd[wordId]) / 2 + 1;
                }
                for (Integer edgeWordId : edgeMap.get(wordId)) {
                    if (distanceBegin[edgeWordId] == -1) {
                        distanceBegin[edgeWordId] = distanceBegin[wordId] + 1;
                        queueBegin.offer(edgeWordId);
                    }
                }
            }

            int endSize = queueEnd.size();
            for (int i = 0; i < endSize; i++) {
                Integer wordId = queueEnd.poll();
                if (distanceBegin[wordId] != -1) {
                    return (distanceBegin[wordId] + distanceEnd[wordId]) / 2 + 1;
                }
                for (Integer edgeWordId : edgeMap.get(wordId)) {
                    if (distanceEnd[edgeWordId] == -1) {
                        distanceEnd[edgeWordId] = distanceEnd[wordId] + 1;
                        queueEnd.offer(edgeWordId);
                    }
                }
            }
        }

        return 0;
    }

    private int v2NodeNum = 0;
    public int version2LadderLength(String beginWord, String endWord, List<String> wordList) {
        if (isEmpty(beginWord) || isEmpty(endWord) || isEmpty(wordList)) {
            return 0;
        }

        Map<String, Integer> wordIdMap = new HashMap<>();
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        v2AddWordAndEdges(wordIdMap, edgeMap, beginWord);
        for (String word : wordList) {
            v2AddWordAndEdges(wordIdMap, edgeMap, word);
        }
        if (!wordIdMap.containsKey(endWord)) {
            return 0;
        }

        int[] distance = new int[v2NodeNum];
        Arrays.fill(distance, -1);

        Integer beginId = wordIdMap.get(beginWord);
        Integer endId = wordIdMap.get(endWord);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);
        distance[beginId] = 0;

        while (!queue.isEmpty()) {
            Integer wordId = queue.poll();
            if (wordId.equals(endId)) {
                return distance[wordId] / 2 + 1;
            }

            int curDist = distance[wordId];
            for (Integer edgeWordId : edgeMap.get(wordId)) {
                if (distance[edgeWordId] == -1) {
                    distance[edgeWordId] = curDist + 1;
                    queue.offer(edgeWordId);
                }
            }
        }

        return 0;
    }

    private void v2AddWordAndEdges(Map<String, Integer> wordIdMap,
                                   Map<Integer, List<Integer>> edgeMap,
                                   String word) {
        int wordId = v2AddWordOrGet(wordIdMap, word);

        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char temp = array[i];
            array[i] = '*';
            Integer virtualWordId = v2AddWordOrGet(wordIdMap, new String(array));
            v2AddEdge(edgeMap, wordId, virtualWordId);
            v2AddEdge(edgeMap, virtualWordId, wordId);
            array[i] = temp;
        }
    }

    private Integer v2AddWordOrGet(Map<String, Integer> wordIdMap, String word) {
        Integer wordId = wordIdMap.get(word);
        if (wordId != null) {
            return wordId;
        }
        wordId = v2NodeNum++;
        wordIdMap.put(word, wordId);
        return wordId;
    }

    private void v2AddEdge(Map<Integer, List<Integer>> edgeMap, Integer wordId, Integer edgeWordId) {
        List<Integer> edges = edgeMap.get(wordId);
        if (edges == null) {
            edges = new LinkedList<>();
            edgeMap.put(wordId, edges);
        }
        edges.add(edgeWordId);
    }

    public int version1LadderLength(String beginWord, String endWord, List<String> wordList) {
        if (isEmpty(beginWord) || isEmpty(endWord) || isEmpty(wordList)) {
            return 0;
        }

        Map<String, WordItem> map = new HashMap<>();
        addWordAndEdges(map, beginWord);
        for (String word : wordList) {
            addWordAndEdges(map, word);
        }

        if (!map.containsKey(endWord)) {
            return 0;
        }

        Map<String, Integer> distMap = new HashMap<>();
        distMap.put(beginWord, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word.equals(endWord)) {
                return distMap.get(word) / 2 + 1;
            }

            int dist = distMap.get(word);
            WordItem wordItem = map.get(word);
            for (String edgeWord : wordItem.edges) {
                if (!distMap.containsKey(edgeWord)) {
                    distMap.put(edgeWord, dist + 1);
                    queue.offer(edgeWord);
                }
            }
        }

        return 0;
    }

    private void addWordAndEdges(Map<String, WordItem> map, String word) {
        WordItem wordItem = addOrFetch(map, word);

        char[] array = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char temp = array[i];
            array[i] = '*';
            String virtualWord = new String(array);
            WordItem virtualWordItem = addOrFetch(map, virtualWord);
            wordItem.addEdge(virtualWord);
            virtualWordItem.addEdge(word);
            array[i] = temp;
        }
    }

    private WordItem addOrFetch(Map<String, WordItem> map, String word) {
        WordItem wordItem = map.get(word);
        if (wordItem == null) {
            wordItem = new WordItem(word);
            map.put(word, wordItem);
        }
        return wordItem;
    }

    private static class WordItem {
        String word;
        Set<String> edges = new HashSet<>();

        public WordItem(String word) {
            this.word = word;
        }

        public void addEdge(String remoteWord) {
            edges.add(remoteWord);
        }
    }

    private boolean isEmpty(String word) {
        return word == null || word.isEmpty();
    }

    private boolean isEmpty(List<String> list) {
        return list == null || list.isEmpty();
    }
}
