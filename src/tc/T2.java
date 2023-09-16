package tc;

import java.util.Arrays;
import java.util.Comparator;

public class T2 {

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
    }

    public int maxEnvelopes (int[][] envelopes) {
        // write code here
        int len = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] h = new int[len];
        for (int i = 0; i < len; i++) {
            h[i] = envelopes[i][1];
        }
        return helper(h);
    }

    static int helper(int[] h) {
        int p = 0;
        int n = h.length;
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            int pp = h[i];
            int l = 0;
            int r = p;
            while (l< r) {
                int mid = (l + r) / 2;
                if (t[mid] >= pp) {
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }
            if (l == p) {
                p ++;
            }
            t[l] = pp;
        }
        return p;
    }
}
