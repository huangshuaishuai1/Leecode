package ershua;

public class T494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int x = (sum + target) / 2;

        int[][] dp = new int[nums.length][x+1];

        // 初始化
        dp[0][nums[0]] = 1;
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j <= x; j++) {
                if(nums[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }else if (nums[i] == j){
                    dp[i][j] = 1 + dp[i-1][j] + dp[i-1][j-nums[i]];

                }else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                }

            }
        }

        return dp[nums.length-1][x];

    }

    public static void main(String[] args) {
        T494 t494 = new T494();
        System.out.println(t494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
