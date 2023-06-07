package dp;

public class T221 {
    public static void main(String[] args) {
        T221 t221 = new T221();
        char[][] m = new char[4][];
        m[0] = new char[]{'1','0','1','0','0'};
        m[1] = new char[]{'1','0','1','1','1'};
        m[2] = new char[]{'1','1','1','1','1'};
        m[3] = new char[]{'1','0','0','1','0'};
        int i = t221.maximalSquare(m);
        System.out.println(i);
    }
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length+1];
        int ans = Integer.MIN_VALUE;
        // 初始化第一行
        for (int i = 1; i <= matrix[0].length; i++) {
            if (matrix[0][i-1] == '1') {
                dp[0][i] = 1;
                ans = 1;
            }else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(matrix[i][j-1] == '0') {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1;
                    ans = Math.max(ans,dp[i][j]*dp[i][j]);
                }

            }
        }
        return ans;
    }
}
