package ershua;

public class T746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.max(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        T746 t746 = new T746();
        System.out.println(t746.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
