package dp;

public class T1035 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 这道题就是和 “最大公共子序列” 一样
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        T1035 t1035 = new T1035();
        System.out.println(t1035.maxUncrossedLines(new int[]{2,5,1,2,5},new int[]{10,5,2,1,5,2}));
    }
}
