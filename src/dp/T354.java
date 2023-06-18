package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T354 {
    public static void main(String[] args) {
        T354 t354 = new T354();
        int[][] envelopes = new int[9][2];
        envelopes[0] = new int[]{1,2};
        envelopes[1] = new int[]{3,3};
        envelopes[2] = new int[]{3,4};
        envelopes[3] = new int[]{3,5};
        envelopes[4] = new int[]{4,5};
        envelopes[5] = new int[]{5,5};
        envelopes[6] = new int[]{5,6};
        envelopes[7] = new int[]{6,7};
        envelopes[8] = new int[]{7,8};
        System.out.println(t354.maxEnvelopes(envelopes));
    }

    public int maxEnvelopes(int[][] envelopes) {
        List<int[]> list = Arrays.stream(envelopes).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[0] - o2[1];
                }
            }
        }).collect(Collectors.toList());

        int[] dp = new int[envelopes.length];
        // dp表示以排序后的 i 信封结尾的最大结果
        dp[0] = 1;
        int ans = 1;
        int nowW = list.get(0)[0];
        int nowH = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            // 如果装不下到前面的那个信封
            int[] envelop = list.get(i);
            int w = envelop[0];
            int h = envelop[1];
            dp[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                int[] envelopJ = list.get(j);
                int wJ = envelopJ[0];
                int hJ = envelopJ[1];
                if (wJ == w) {
                    continue;
                }
                if (hJ > h) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if (dp[i] > ans) {
                        break;
                    }
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
