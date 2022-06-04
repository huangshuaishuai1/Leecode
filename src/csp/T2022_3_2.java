package csp;


import java.util.Scanner;


public class T2022_3_2 {
    public static void main(String[] args) {
        int[] sum = new int[400005];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            int left = t - c - k + 1;
            int right = t - k;
            if (right < 1) {
                continue;
            }
            left = Math.max(left,1);
            sum[left]++;
            sum[right+1]--;
        }
        sum[0] = 0;
        for (int i = 1; i < 400005; i++) {
            sum[i] = sum[i] + sum[i-1];
        }
        for (int i = 0; i < m; i++) {
            System.out.println(sum[scanner.nextInt()]);
        }

    }
}
