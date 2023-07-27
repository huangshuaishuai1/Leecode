package graph;

import java.util.HashMap;
import java.util.Objects;

public class T839 {
    public static void main(String[] args) {
        T839 t839 = new T839();
        System.out.println(t839.numSimilarGroups(new String[]{"omv","ovm"}));
    }

    public int numSimilarGroups(String[] strs) {
        int[] parents = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSame(strs[i], strs[j])) {
                    union(parents, i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < strs.length; i++) {
            if (parents[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    int findParent(int[] parents, int x) {
        if (parents[x] == x) {
            return x;
        }

        return findParent(parents,parents[x]);
    }

    void union(int[] parents, int a, int b) {
        int aP = findParent(parents, a);
        int  bP = findParent(parents, b);

        if (aP > bP) {
            parents[aP] = bP;
        }else {
            parents[bP] = aP;

        }
    }

    // 判断两个单词是否相似
    boolean isSame(String a, String b) {
        if (Objects.equals(a, b)) {
            return true;
        }
        int first = 0;
        int second = 0;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (count == 0) {
                    first = i;
                } else if (count == 1) {
                    second = i;
                }
                count++;
            }
        }
        if (count == 2 && a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first)) {
            return true;
        }
        return false;
    }


}
