package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class T377 {
    public int combinationSum4(int[] nums, int target) {
//        int[][] dp = new int[nums.length+1][target+1];
        Arrays.sort(nums);
//        dp[0][0] = 1;
//        for (int i = 1; i <= nums.length; i++) {  // 记得i-1取num
//            for (int j = 1; j <= target; j++) {
//
//            }
//        }

        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i) {
                    break;
                }else {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[dp.length-1];
    }


    public static void main(String[] args) {
        T377 t377 = new T377();
        int[] ints = {3,2,1};
        int target = 4;
        int i = t377.combinationSum4(ints, target);
        System.out.println(i);
    }
}
