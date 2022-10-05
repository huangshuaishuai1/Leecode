package dp;

import java.util.Arrays;

public class T300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < dp.length; i++) {
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        T300 t300 = new T300();
        System.out.println(t300.lengthOfLIS(new int[]{
                10, 9, 2, 5, 3, 7, 101, 18
        }));
    }
}
