package weizhong;

import java.util.Scanner;

public class TT1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] arrayA = new long[N];
        long[] arrayB = new long[N];
        long La = 0;
        long Ra = 0;
        long Lb = 0;
        long Rb = 0;
        for (int i = 0; i < N; i++) {
            arrayA[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arrayB[i] = scanner.nextInt();
        }
        La = scanner.nextInt();
        Ra = scanner.nextInt();
        Lb = scanner.nextInt();
        Rb = scanner.nextInt();
        long res = countIntervals(N, arrayA, arrayB, La, Ra, Lb, Rb);
        System.out.println(res);
    }
    public static long countIntervals(int n, long[] a, long[] b, long La, long Ra, long Lb, long Rb) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            long sumA = a[i];
            long sumB = b[i];
            if (sumA >= La && sumA <= Ra && sumB >= Lb && sumB <= Rb) {
                res++;
            }
            for (int j = i + 1; j < n; j++) {
                sumA += a[j];
                sumB += b[j];
                if (sumA >= La && sumA <= Ra && sumB >= Lb && sumB <= Rb) {
                    res++;
                }
            }
        }
        return res;
    }
}
