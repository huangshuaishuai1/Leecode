package dp;

public class T2466 {

    public static void main(String[] args) {
        T2466 t2466 = new T2466();
        System.out.println(t2466.countGoodStrings(1, 100000, 1, 1));
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                dp[i] += dp[i-zero];
            }
            if (i - one >= 0) {
                dp[i] += dp[i-one];
            }
            dp[i] = dp[i] % 1000000007;
        }
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + dp[i]) % 1000000007;
        }
        return ans;
    }
}
