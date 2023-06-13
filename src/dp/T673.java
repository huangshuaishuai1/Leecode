package dp;

public class T673 {

    public static void main(String[] args) {
        T673 t673 = new T673();
        System.out.println(t673.findNumberOfLIS(new int[]{1,3,2}));
    }

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] ans = new int[nums.length];
        int maxLen = 0, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            ans[i] = 1;
            for (int j = i-1; j >=0 ; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 == dp[i]) {
                        ans[i] += ans[j];
                    }else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j]+1;
                        ans[i] = ans[j];
                    }
                }
            }
            if (dp[i] == maxLen) {
                ret += ans[i];
            }else if (dp[i] > maxLen) {
                ret = ans[i];
                maxLen = dp[i];
            }
        }

        return ret;
    }
}
