package dp.pack;

import java.util.Arrays;

public class T416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int pack = sum / 2;
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][pack+1];
        
        // 初始化dp数组
        for (int i = 0; i < pack+1; i++) {
            if (i >= nums[0]) {
                dp[0][i] = nums[0];
            }else {
                dp[0][i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }

        // 开始规划
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < pack+1; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]] + nums[i]);
                }
            }
        }
        if (dp[nums.length-1][pack] == pack) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        T416 t416 = new T416();
        System.out.println(t416.canPartition(new int[]{1, 2, 3, 5}));
    }
}
