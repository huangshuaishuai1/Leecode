package dp;

public class T96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 2*dp[i-1];
            for (int j = 1; j <= i-2; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    private int helper(int n) {
        int mul = 1;
        for (int i = 2; i <= n; i++) {
            mul = mul * i;
        }
        return mul;
    }

    public static void main(String[] args) {
        T96 t96 = new T96();
        System.out.println(t96.numTrees(5));
    }
}
