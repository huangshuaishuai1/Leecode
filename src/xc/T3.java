package xc;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[200010];
        while ((t--)>0){
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            long sum = 0;
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
                sum+=a[i];
            }
            if (sum > r*n || l*n>sum) {
                System.out.println(-1);
                continue;
            }
            helper( a, n, l, r);

        }
    }

    private static void helper(int[] a, int n, int l, int r) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] > r) {
                ans -= a[i] -r;
            }
        }
        long add = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] < l) {
                add+=l-a[i];
            }
        }
        System.out.println(Math.max(add,-ans));
    }
}
