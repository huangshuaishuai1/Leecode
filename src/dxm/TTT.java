package dxm;

import java.util.Scanner;

public class TTT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] work = new int[n];
        for (int i = 0; i <n; i++) {
            work[i] = scanner.nextInt();
        }
        if (n <= 2) {
            System.out.println(Math.max(work[0],work[1]));
            return;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = work[0];
        dp[2] = Math.max(work[1],work[2]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-3]+work[i-1],dp[i-2]+work[i-1]));
        }

        System.out.println(dp[n]);
    }
}
