package dp;

import java.util.Arrays;

public class T115 {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0],1);
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        T115 t115 = new T115();
        System.out.println(t115.numDistinct("babgbag", ""));
    }
}
