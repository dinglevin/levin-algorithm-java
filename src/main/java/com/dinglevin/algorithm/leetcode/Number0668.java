package com.dinglevin.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述：Number668
 *
 * @author dinglevin
 * @since 2021/6/19 14:53 周六
 */
public class Number0668 {
    public int version1FindKthNumber(int m, int n, int k) {
        int[] table = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i * n + j] = (i + 1) * (j + 1);
            }
        }
        Arrays.sort(table);
        return table[k - 1];
    }

    public int version2FindKthNumber(int m, int n, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>(m,
                Comparator.comparingInt(node -> node.value));

        for (int i = 1; i <= m; i++) {
            queue.offer(new Node(i, i));
        }

        Node node = null;
        for (int i = 0; i < k; i++) {
            node = queue.poll();
            int next = node.value + node.root;
            if (next <= node.root * n) {
                queue.offer(new Node(next, node.root));
            }
        }

        return node.value;
    }

    public int version3FindKthNumber(int m, int n, int k) {
        int low = 1, high = n * m;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (enough(mid, m, n, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    private static class Node {
        int value;
        int root;

        public Node(int value, int root) {
            this.value = value;
            this.root = root;
        }

        @Override
        public String toString() {
            return "(" + value + "," + root + ")";
        }
    }
}
