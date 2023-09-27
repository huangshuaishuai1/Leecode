package mihayou;

public class T3 {

    static double calculateProbability(int n, int x) {
        if (n < 1  || x > 6*n) {
            return 0.0;
        }
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 0; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6*i ; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= i - 1) {
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }
        int total = (int) Math.pow(6,n);
        double pro = 0.0;
        for (int i = x; i <= 6*n; i++) {
            pro += dp[n][i];
        }
        return pro / total;
    }

    public static void main(String[] args) {
        int n = 2;
        int x = 7;
        double ret = calculateProbability(n,x);
        System.out.println(ret);
    }
}
