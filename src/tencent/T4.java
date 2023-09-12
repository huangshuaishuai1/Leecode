package tencent;

import java.util.Scanner;

public class T4 {
    static int MOD_NUMBER = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long N = sc.nextLong();
            long K = sc.nextLong();
            long a = 2;
            long ans = 1;
            long b = N-K;
            while (b > 0) {
                if ((b & 1) == 1) {
                    ans = ans * a % MOD_NUMBER;
                }
                a =a * a % MOD_NUMBER;
                b >>=1;
            }
            System.out.println((ans-1) % MOD_NUMBER);
        }
    }

}
