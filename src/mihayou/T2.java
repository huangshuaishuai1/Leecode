package mihayou;

import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h = scanner.nextInt();
        int coin = 0;
        int a = 0;
        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            int number = scanner.nextInt();
            if (type == 1) {
                coin+=number;
            }else {
                h -= number;
                a += coin;
                coin = 0;

            }
        }
        // 现在剩下 h点血， 有 a 次 投掷银币的机会
        if (h <= 0 || h <= a) {
            System.out.println(1);
            return;
        }
        if (h > 6*a) {
            System.out.println(0);
            return;
        }
        System.out.println(calculateProbability(a,h));

    }
    static double calculateProbability(int n, int x) {
        if (n < 1  || x > 6*n) {
            return 0.0;
        }
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 0; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6*i ; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= i - 1) {
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }
        int total = (int) Math.pow(6,n);
        double pro = 0.0;
        for (int i = x; i <= 6*n; i++) {
            pro += dp[n][i];
        }
        return pro / total;
    }
}
