package dp;

public class T931 {
    public static void main(String[] args) {


    }
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0) {
                    dp[i][0] = Math.min(dp[i-1][0],dp[i-1][1]) + matrix[i][0];
                }else if (j == matrix.length-1) {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + matrix[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1])) + matrix[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            ans = Math.min(ans,dp[matrix.length-1][i]);
        }
        return ans;
    }
}
