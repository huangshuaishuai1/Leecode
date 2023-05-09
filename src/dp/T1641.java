package dp;

import java.util.Arrays;

public class T1641 {
    public static void main(String[] args) {
        T1641 t1641 = new T1641();
        System.out.println(t1641.countVowelStrings(33));
    }
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 4; j >= 0; j--) {
                sum += dp[j];
                dp[j] = sum;
            }
        }
        return Arrays.stream(dp).sum();
    }
}
