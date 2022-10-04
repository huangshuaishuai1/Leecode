package dp;

public class T188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        dp[0][0] = 0;
        dp[0][1] = -prices[0]; // 第一次买入
        for (int i = 3; i <= 2*k; i=i+2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][2*j-1] = Math.max(dp[i-1][2*j-1],dp[i-1][2*j-2]-prices[i]);
                dp[i][2*j] = Math.max(dp[i-1][2*j],dp[i-1][2*j-1]+prices[i]);
            }
        }
        return dp[prices.length-1][2*k];
    }

    public static void main(String[] args) {
        T188 t188 = new T188();
        System.out.println(t188.maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
}
