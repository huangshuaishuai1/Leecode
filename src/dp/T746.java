package dp;

public class T746 {

    public int minCostClimbingStairs(int[] cost) {
        // 确定dp数组dp[i]的含义
        // dp[i] 表示上第i个阶梯最小代价
        int[] dp = new int[cost.length + 1];
        // 确定递推公式
        // dp[i] = min(dp[i-1],dp[i-2])+cost[i]

        // 确定初始化值
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            if (i == cost.length) {
                dp[i] = Math.min(dp[i-1],dp[i-2]);
            }else {
                dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        T746 t746 = new T746();
        System.out.println(t746.minCostClimbingStairs(cost));

    }
}
