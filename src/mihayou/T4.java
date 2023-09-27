package mihayou;

import java.util.Scanner;

public class T4 {

    static int MOD = 1000000007;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n+1];
        long[] dp = new long[n+1];
        dp[1] = 0;
        // dp[i] = (dp[i-1]/2 + count[i-1])*a[i];
        int[] count = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i+1] = scanner.nextLong();
            sum += a[i+1];
            count[i+1] = sum;
        }
        sum = 0;
        for (int i = 2; i <= n; i++) {
            sum += count[i-1];
            dp[i] = (dp[i-1] + sum) * a[i];
            dp[i] %= MOD;
        }
        System.out.println(dp[n]);
    }
}
