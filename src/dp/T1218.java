package dp;

import java.util.HashMap;

public class T1218 {

    public static void main(String[] args) {
        T1218 t1218 = new T1218();
        System.out.println(t1218.longestSubsequence(new int[]{3,4,-3,-2,-4}, -5));
    }

    public int longestSubsequence(int[] arr, int difference) {
        // dp[i] 表示以元素arr[i]为结尾的最长等差子序列的长度
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int v : arr) {
            dp.put(v,dp.getOrDefault(v-difference,0)+1);
            ans = Math.max(ans,dp.get(v));
        }
        return ans;

    }
}
