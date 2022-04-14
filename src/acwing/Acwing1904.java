package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing1904 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int N = scanner.nextInt();
        int[] X = new int[N];
        int[] Y = new int[N];
        int dis = 0;
        for (int i = 0; i < N; i++) {
            X[i] = scanner.nextInt();
            Y[i] = scanner.nextInt();
            if (i > 0) {
                int disOnec = Math.abs(X[i] - X[i-1]) + Math.abs(Y[i] - Y[i-1]);
                dis += disOnec;
            }
        }
        int[] distance = new int[N - 2];
        for (int i = 1; i < N-1; i++) {
            int gap = Math.abs(X[i] - X[i-1]) + Math.abs(Y[i] - Y[i-1]) + Math.abs(X[i+1] - X[i]) + Math.abs(Y[i+1] - Y[i]) - Math.abs(X[i+1] - X[i-1]) - Math.abs(Y[i+1] - Y[i-1]);
            distance[i - 1] = dis - gap;
        }
        Arrays.sort(distance);
        System.out.println(distance[0]);
    }
}
