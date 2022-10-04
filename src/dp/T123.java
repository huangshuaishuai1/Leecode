package dp;

public class T123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0; // 不操作
        dp[0][1] = 0; // 在该下标第一次卖出
        dp[0][2] = -prices[0]; // 在垓下标第一次买入
        dp[0][3] = 0; // 在该下标第二次卖出
        dp[0][4] = -prices[0]; // 在该下标第二次买入
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]+prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0]-prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][4]+prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][1]-prices[i]);
        }
        return dp[prices.length-1][3];
    }


    public static void main(String[] args) {
        T123 t123 = new T123();
        System.out.println(t123.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
