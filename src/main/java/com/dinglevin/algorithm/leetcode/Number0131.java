package com.dinglevin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述：Number131
 *
 * @author dinglevin
 * @since 2021/6/20 16:12 周日
 */
public class Number0131 {
    public List<List<String>> version1Partition(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        return dfs(s, n, 0, f, result, ans);
    }

    private List<List<String>> dfs(String s,
                                   int n,
                                   int i,
                                   boolean[][] f,
                                   List<List<String>> result,
                                   List<String> ans) {
        if (i == n) {
            result.add(new ArrayList<>(ans));
            return result;
        }

        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, n, j + 1, f, result, ans);
                ans.remove(ans.size() - 1);
            }
        }

        return result;
    }
}
