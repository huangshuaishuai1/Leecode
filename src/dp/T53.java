package dp;

public class T53 {

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
           dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
           ret = Math.max(ret,dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        T53 t53 = new T53();
        System.out.println(t53.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
