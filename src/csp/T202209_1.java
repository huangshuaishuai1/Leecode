package csp;

import java.util.Scanner;

public class T202209_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[n];
        int[] sum = new int[n];
        int[] c = new int[n+1];
        int[] b = new int[n];
        c[0] = 1;
        a[0] = scanner.nextInt();
        c[1] = c[0] * a[0];
        sum[0] =(a[0]-1)*c[0];
        for (int i = 1; i < n; i++) {
            a[i] = scanner.nextInt();
            c[i+1] = c[i] * a[i];
            sum[i] = sum[i-1] + (a[i]-1)*c[i];
        }

        for (int i = n-1; i >=0 ; i--) {
            if (m < c[i]) {
                b[i] = 0;
            }else {
                int tmp = m ;
                if (i > 0) {
                    tmp-= sum[i-1];
                }

                b[i] = tmp / c[i] + 1;
                if (tmp % c[i] == 0) {
                    b[i]=b[i]-1;
                }
                m -= b[i] * c[i];
            }
        }

        System.out.print(b[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(" "+b[i]);
        }
    }
}
