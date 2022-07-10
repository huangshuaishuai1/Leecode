package dp;

public class T62 {
    public int uniquePaths(int m, int n) {
        // 先确定dp数组的意义
        // dp[i][j] 表示到坐标（i，j）的路径数
        int dp[][] = new int[m][n];
        // 确定递推公式
        // dp[i][j] = dp[i][j-1] + dp[i-1][j]

        // 确定初始化值
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
