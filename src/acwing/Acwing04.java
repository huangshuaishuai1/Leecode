package acwing;

import java.util.Scanner;

public class Acwing04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();

        int[] v = new int[N+1];
        int[] w = new int[N+1];
        int[] s = new int[N+1];

        for (int i = 1; i <= N; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            s[i] = scanner.nextInt();
        }
        int[][] used = new int[V+1][N + 1];
        int[] dp = new int[V+1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= N; j++) {
                if (i >= v[j] && used[i-v[j]][j] < s[j]) {
                    if (dp[i]<=dp[i-v[j]]+w[j]){
                        dp[i] = dp[i-v[j]]+w[j];
                        used[i] = used[i-v[j]].clone();
                        used[i][j]++;
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }
}
