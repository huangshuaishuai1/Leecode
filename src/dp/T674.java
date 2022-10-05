package dp;

import java.util.Arrays;

public class T674 {

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (nums[j] < nums[j+1]) {
                    dp[i]++;
                }else {
                    break;
                }
            }
        }
        int ret = 0 ;
        for (int i = 0; i < dp.length; i++) {
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        T674 t674 = new T674();
        System.out.println(t674.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

}
