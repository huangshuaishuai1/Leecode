package KDXF;

import java.util.Scanner;

public class T16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] H = new int[N + 1];
        for (int i = 0; i < N; i++) {
            H[i+1] = scanner.nextInt();
        }

        int[] dp = new int[N+1];

        dp[N] = 0;
        for (int i = N-1; i >= 0; i--) {
            if ((dp[i+1] + H[i+1]) % 2 == 0) {
                dp[i] = (dp[i+1] + H[i+1]) / 2;
            }else {
                dp[i] = (dp[i+1] + H[i+1]) / 2 + 1;
            }
        }
        System.out.println(dp[0]);
    }


}





