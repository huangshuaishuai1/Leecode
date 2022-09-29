package dp;

public class T213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }
        int i = robHelper(nums, 0, nums.length - 1);
        int j = robHelper(nums, 1, nums.length);
        return Math.max(i,j);
    }
    public int robHelper(int[] nums, int start, int end) {
        int dp[] = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max((dp[i-2] + nums[i-1+start]), dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        T213 t213 = new T213();
        System.out.println(t213.rob(new int[]{1, 2, 3, 1}));

    }
}
