package dp.pack;

import java.util.Arrays;

public class T494 {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] == -target) {
            return 1;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int x = (target + sum) / 2;
        int[][] dp = new int[nums.length][x+1];
        // 初始化
        for(int i = 0 ; i <= x; i++) {
            if(i == nums[0]) {
                dp[0][i] = 1;
            }else {
                dp[0][i] = 0;
            }
        }

        dp[0][0] ++;

        for(int i = 1; i < nums.length; i++ ){
            for(int j = 0; j <= x; j++) {
                if(nums[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][x];
    }

    public static void main(String[] args) {
        T494 t494 = new T494();
        System.out.println(t494.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
