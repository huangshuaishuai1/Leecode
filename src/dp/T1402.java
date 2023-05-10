package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1402 {
    public static void main(String[] args) {
        T1402 t1402 = new T1402();
        System.out.println(t1402.maxSatisfaction(new int[]{-1,-4,-5}));
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length][satisfaction.length];
        for (int i = 0; i < satisfaction.length; i++) {
            dp[i][i] = satisfaction[i];
        }
        for (int i = 1; i < satisfaction.length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = dp[i-1][j] + satisfaction[i] * (i-j+1);
            }
        }
        int max = 0;
        for (int i = 0; i < dp[0].length; i++) {
            max = Math.max(max,dp[dp.length-1][i]);
        }

        return max;
    }
}
