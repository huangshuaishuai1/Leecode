package fiveeight;

public class T3 {

    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.subsequence("ABC", "A"));
    }
    static int lenS = 0;
    static int lenP = 0;
    public int subsequence (String source, String pattern) {
        // write code here

        lenS = source.length();
        lenP = pattern.length();

        int [][] dp = new int[lenS+1][lenP+1];

        for (int i = 0; i <= lenS; i++) {
            dp[i][0] = 1;
        }
        return helper(dp,source,pattern);

    }
    static int helper(int[][] dp,String source, String pattern) {
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if (pattern.charAt(j-1) == source.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1]+ dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[lenS][lenP];
    }
}
