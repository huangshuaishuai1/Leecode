package dp;

import java.util.Arrays;

public class T392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][t.length()+1];
//        Arrays.fill(dp,false);
//        if (s.charAt(0) == t.charAt(0)) {
//            dp[1][1] = true;
//        }
        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = true;
        }
        int tmp = 1;
        for (int i = 1; i <= s.length(); i++) {

            for (int j = tmp; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j];
                    for (int k = j+1; k <= t.length(); k++) {
                        dp[i][k] = dp[i][j];
                    }
                    tmp = j+1;
                    break;
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        T392 t392 = new T392();
        System.out.println(t392.isSubsequence("axc", "ahbgdc"));
    }

}
