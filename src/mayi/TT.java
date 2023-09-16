package mayi;

import java.util.Scanner;

public class TT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int now = 0;
        while (k > 0) {
            int tmp = Math.min(k,a[now]);
            a[now++] -= tmp;
            a[n-1] += tmp;
            k-=tmp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
