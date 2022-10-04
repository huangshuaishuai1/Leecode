package dp;

public class T309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0; //卖出
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(Math.max(dp[i-1][2],(dp[i-1][1] + prices[i])),dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]-prices[i]);
            dp[i][2] = dp[i-1][0];
        }
        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        T309 t309 = new T309();
        System.out.println(t309.maxProfit(new int[]{1,2,3,0,2}));
    }
}
