package csp;

import java.util.Scanner;

public class T202209_2 {

    public static int ret = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        helper(0,a,0,x);
        System.out.println(ret);

    }

    private static void helper(int startIndex, int[] a, int sum, int x) {

        if (sum >= x) {
            if (sum < ret || ret == 0) {
                ret = sum;
            }
            return;
        }

        for (int i = startIndex; i < a.length; i++) {
            sum += a[i];
            helper(i+1,a,sum,x);

            // 回溯
            sum -= a[i];
        }
    }
}
