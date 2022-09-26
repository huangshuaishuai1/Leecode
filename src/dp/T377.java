package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class T377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        T377 t377 = new T377();
        int[] ints = {3,2,1};
        int target = 4;
        int i = t377.combinationSum4(ints, target);
        System.out.println(i);
    }
}
