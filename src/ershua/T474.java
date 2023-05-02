package ershua;

public class T474 {

    public static void main(String[] args) {

    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];
        int[][] countNumbers = new int[strs.length][2];

        for (int i = 0; i < strs.length; i++) {
            countNumbers[i] = helper(strs[i]);
        }

        for (int i = 0; i < strs.length; i++) {
            int zero = countNumbers[i][0];
            int one = countNumbers[i][1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < n; k++) {
                    if (zero > m || one > n) {
                        dp[i][j][k] = dp[i-1][j][k];
                    }else {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-zero][k-one] + 1);
                    }
                }
            }
        }
        return dp[strs.length-1][m][n];
    }

    private int[] helper(String str) {
        char[] chars = str.toCharArray();
        int one = 0;
        int zero = 0;

        for (char aChar : chars) {
            if (aChar == '1') {
                one++;
            }else {
                zero++;
            }
        }
        int[] ints = {one, zero};
        return ints;
    }
}
