package dp.pack;

import java.util.Arrays;

public class T1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        Arrays.sort(stones);
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length][target + 1];
        // 初始化
        for (int i = 0; i < stones.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < target + 1; i++) {
            if (i >= stones[0]) {
                dp[0][i] = stones[0];
            }else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j < target+1; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }
            }
        }
        return Math.abs(dp[stones.length-1][target] - (sum - dp[stones.length-1][target]));
    }

    public static void main(String[] args) {
        T1049 t1049 = new T1049();
        System.out.println(t1049.lastStoneWeightII(new int[]{31,26,33,21,40}));

    }
}
