package dp.pack;

import java.util.Arrays;

public class T279 {
    public int numSquares(int n) {
        double sqrt = Math.sqrt(n);
        int sqrt_n =(int) Math.floor(sqrt);
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int[] nums = new int[sqrt_n];
        for (int i = 1; i <= sqrt_n; i++) {
            nums[i-1] = i;
        }
        for (int i = 0; i < sqrt_n; i++) {
            for (int j = nums[i] * nums[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j],dp[j-nums[i]*nums[i]]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        T279 t279 = new T279();
        System.out.println(t279.numSquares(12));
    }
}
