package dp;

public class T790 {
    public static void main(String[] args) {
        T790 t790 = new T790();
        int i = t790.numTilings(3);
        System.out.println(i);
    }

    public int numTilings(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n+1][4];
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = dp[i-1][3];
            dp[i][1] = dp[i-1][0] + dp[i-1][2];
            dp[i][2] = dp[i-1][0] + dp[i-1][1];
            dp[i][3] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3];
        }

        return dp[n][3];
    }
}
