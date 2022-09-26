package dp.pack;

import java.util.Arrays;
import java.util.Comparator;

public class T322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    if (dp[i-coins[j]] != -1) {
                        if (dp[i] != -1) {
                            dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                        }else {
                            dp[i] = dp[i-coins[j]]+1;
                        }
                    }

                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        T322 t322 = new T322();
        System.out.println(t322.coinChange(coins, amount));
    }
}
