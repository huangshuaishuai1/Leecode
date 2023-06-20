package dp;

public class T1312 {

    public int minInsertions(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];

        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (s.charAt(i-1) == s.charAt(s.length()-j)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return s.length() - dp[dp.length-1][dp.length-1];
    }

    public static void main(String[] args) {
        T1312 t1312 = new T1312();
        int i = t1312.minInsertions("leetcode");
        System.out.println(i);
    }

}
