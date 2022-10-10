package dp;

public class T516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for (int i = s.length(); i >= 1; i--) {
            for (int j = i; j < s.length()+1; j++) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    if (i == j) {
                        dp[i][j] = 1;
                    }else if(j-i==1){
                        dp[i][j] = 2;
                    }
                    else {
                        ///dp[i][j] = Math.max(Math.max(dp[i][j-1],dp[i+1][j]),dp[i+1][j-1])+2;
                        dp[i][j] = dp[i+1][j-1]+2;

                    }
                }else{
                    dp[i][j] = Math.max(Math.max(dp[i][j-1],dp[i+1][j]),dp[i+1][j-1]);

                }
            }
        }
        return dp[1][s.length()];
    }

    public static void main(String[] args) {
        T516 t516 = new T516();
        System.out.println(t516.longestPalindromeSubseq("cbbd"));
    }
}
