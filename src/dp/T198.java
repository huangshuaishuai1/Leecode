package dp;

public class T198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max((dp[i-2] + nums[i-1]), dp[i-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        T198 t198 = new T198();
        System.out.println(t198.rob(new int[]{2, 7, 9, 3, 1}));
    }


}
