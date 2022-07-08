package dp;

public class T70 {
    //确定dp数组的下标意义
    // 下标意义是上楼的方式种数
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        // 确定递推公式
        // dp[i] = dp[i-1]+dp[i-2]
        // 确定dp数组的初始化值
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        T70 t70 = new T70();
        System.out.println(t70.climbStairs(1));

    }
}
