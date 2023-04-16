package acwing;

import java.util.Scanner;

public class Acwing03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] w = new int[N+1];
        int[] v = new int[N+1];

        for (int i = 1; i <= N; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }
        int[] dp = new int[V+1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= N ; j++) {
                if (i - w[j] >= 0) {
                    dp[i] = Math.max(dp[i],dp[i-w[j]]+v[j]);
                }
            }
        }
        System.out.println(dp[V]);

    }
}

