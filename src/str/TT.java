package str;

public class TT {
    public static int minMutationTime(String A, String B, int x, int y, int z) {
        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m + 1][n + 1];

        // 删除
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + y;
        }
        // 增加
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + x;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int deletion = dp[i - 1][j] + y;
                    int insertion = dp[i][j - 1] + x;
                    int replacement = dp[i - 1][j - 1] + z;
                    dp[i][j] = Math.min(deletion, Math.min(insertion, replacement));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(TT.minMutationTime("ACGT", "AGCT", 1, 2, 3));

    }
}
