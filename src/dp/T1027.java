package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1027 {

    public static void main(String[] args) {
        T1027 t1027 = new T1027();
        int i = t1027.longestArithSeqLength(new int[]{9, 4, 7, 2, 10});
        System.out.println(i);
    }
    public int longestArithSeqLength(int[] nums) {
        int ans = 1;
        int[][] dp = new int[nums.length][1001];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i],1);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int gap = nums[i] - nums[j] + 500;
                dp[i][gap] = Math.max(dp[i][gap], dp[j][gap] + 1);
                ans = Math.max(ans,dp[i][gap]);
            }

        }
        return ans;
    }

}
