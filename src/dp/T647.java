package dp;

public class T647 {

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ret = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || j-i == 1) {
                        ret++;
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                        if (dp[i][j]){
                            ret++;
                        }
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T647 t647 = new T647();
        System.out.println(t647.countSubstrings("aaa"));
    }
}
