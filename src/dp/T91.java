package dp;

public class T91 {
    public static void main(String[] args) {
        T91 t91 = new T91();
        System.out.println(t91.numDecodings("230"));
    }

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length() ; i++) {
            if ("00".equals(s.substring(i-2,i))){
                return 0;
            }
            else if (s.charAt(i-1) == '0') {
                if (s.charAt(i-2) > '2') {
                    return 0;
                }
                dp[i] = dp[i-2];
            } else if (s.charAt(i-2) == '0'){
                dp[i] = dp[i-1];
            }
            else if (Integer.valueOf(s.substring(i-2,i)) >= 10 && Integer.valueOf(s.substring(i-2,i)) <= 26) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }

        }
        return dp[dp.length-1];
    }

}
