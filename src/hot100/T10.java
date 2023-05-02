package hot100;

public class T10 {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        // 第一维度是s的长度，第二维是p的长度
        // dp[i][j] 表示 p长度为j是否能匹配s长度为i
        // 初始化，当j为0时，只有i为0时是true，否则都为false
        dp[0][0] = true;
        // 当i为0时，若为j为* 则和j-2一样
        for(int j = 1; j <= p.length(); j++) {
            if(p.charAt(j-1) == '*' && dp[0][j-2]) {
                dp[0][j] = true;
            }
        }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                if(p.charAt(j-1) == '*'  ) {
                    if(p.charAt(j-2) == '.'){
                        if(dp[i][j-1] || dp[i-1][j] || dp[i][j-2]) {
                            dp[i][j] = true;
                        }
//                        for(int k = j; k >= j; k--) {
//                            if(dp[i-1][k]) {
//                                dp[i][j] = true;
//                                break;
//                            }
//                        }
                    }else {
                        if(dp[i][j-1] || dp[i][j-2] || (dp[i-1][j] && (s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'))) {
                            dp[i][j] = true;
                        }
                    }

                }else if(p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = (dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1));
                }
            }
        }
        return dp[s.length()][p.length()];

    }



    public static void main(String[] args) {
        T10 t10 = new T10();
        System.out.println(t10.isMatch("a", "..*"));
    }
}

