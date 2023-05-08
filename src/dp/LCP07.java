package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LCP07 {

    public static void main(String[] args) {
        LCP07 lcp07 = new LCP07();
        int[][] ints = new int[2][2];
        ints[0][0] = 0;
        ints[0][1] = 2;
        ints[1][0] = 2;
        ints[1][1] = 1;
        System.out.println(lcp07.numWays(3, ints, 2));
    }
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            int start = relation[i][0];
            int end = relation[i][1];
            if (map.containsKey(start)) {
                map.get(start).add(end);
            }else {
                HashSet<Integer> integers = new HashSet<>();
                integers.add(end);
                map.put(start,integers);
            }
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (!map.containsKey(l)){
                        continue;
                    }
                    if (map.get(l).contains(j)) {
                        dp[i][j] += dp[i-1][l];
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
