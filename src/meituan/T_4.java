package meituan;

import java.util.*;

public class T_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
        ArrayList<int[]> objs = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int[] obj = new int[2];
            obj[0] = sc.nextInt();
            obj[1] = sc.nextInt();
            objs.add(obj);
        }

        int[][][] dp = new int[n][x+1][y+1];
        int money = Integer.MAX_VALUE;
        int ans = 0;

        for (int j = x; j >= objs.get(0)[1]; --j) {
            for (int k = y; k >= 0; --k) {
                if (j >= objs.get(0)[0])
                    dp[0][j][k] = 1;
                if (k >= 1 && j >= objs.get(0)[1])
                    dp[0][j][k] = 1;
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = x; j >= 0; --j) {
                for (int k = y; k >= 0; --k) {
                    if (j >= objs.get(i)[0])
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-objs.get(i)[0]][k] + 1);

                    if (k >= 1 && j >= objs.get(i)[1])
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-objs.get(i)[1]][k-1] + 1);

                    if (dp[i][j][k] > ans) {
                        ans = dp[i][j][k];
                        money = j;
                    } else if (dp[i][j][k] == ans && j < money) {
                        money = j;
                    }
                }
            }
        }

        System.out.println(ans + " " + money);
    }
}