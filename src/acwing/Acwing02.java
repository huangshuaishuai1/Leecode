package acwing;

import java.util.Scanner;

public class Acwing02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();

        int[][] number = new int[N][2];
        for (int i = 0; i < N; i++) {
            number[i][0] = scanner.nextInt();
            number[i][1] = scanner.nextInt();
        }

        int[][] dp = new int[N+1][V+1];
        for (int i = 1; i <= V; i++) {
            if (number[0][0] <= i) {
                dp[1][i] = number[0][1];
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= V; j++) {
                if (number[i][0] > j) {
                    dp[i+1][j] = dp[i][j];
                }else {
                    dp[i+1][j] = Math.max(dp[i][j],dp[i][j-number[i][0]]+number[i][1]);
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
