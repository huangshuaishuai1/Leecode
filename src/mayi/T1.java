package mayi;

import java.util.ArrayList;
import java.util.Scanner;

public class T1 {
    // 质数只和还是质数

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (isZhishu(i)) {
                dp[i] = i;
            }else {
                dp[i] = dp[i-1];
            }
        }

//        for (int i = n; i >= n/2; i--) {
            for (int j = n; j >=n/2 ; j--) {
                int a = dp[j];
                int b = dp[n - dp[j]];
                if (isZhishu(a + b) && isZhishu(a) && isZhishu(b) && a+b <n) {
                    System.out.println(a + " " + b);
                    return;
                }
            }
//        }
        System.out.println(-1);
    }

    private static boolean isZhishu(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
