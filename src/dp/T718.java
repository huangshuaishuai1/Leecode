package dp;

public class T718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
            }
        }
        int ret = 0;
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ret = Math.max(ret,dp[i][j]);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T718 t718 = new T718();
        System.out.println(t718.findLength(new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}));
    }
}
