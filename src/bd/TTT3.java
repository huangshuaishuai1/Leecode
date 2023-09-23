package bd;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TTT3{
    static long MOD = 1000000007;
    public int cntOfMethod(String t) {
        long[] dp = new long[t.length()+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 3; i < t.length(); i++) {
            long tmp = dp[i];
            for (int j = 2; 2* j <= i+1 ; j++) {
                String sub1 = t.substring(i-j+1,i+1);
                String sub2 = t.substring(i-j*2+1,i-j+1);
                if (sub1.equals(sub2)) {
                    tmp+=dp[i-j + 1];
                    tmp %= MOD;
                }
            }
            dp[i+1] = tmp;
        }

        return (int) dp[t.length()];
    }

    public static void main(String[] args) {
        TTT3 ttt3 = new TTT3();
        System.out.println(ttt3.cntOfMethod("ababab"));

    }
}
