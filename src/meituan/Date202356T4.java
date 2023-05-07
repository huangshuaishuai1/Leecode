package meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Date202356T4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] a = new long[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ArrayList<Long> integers = new ArrayList<>();
            while (i < n&& w[i] != 2) {
                if (k >= a[i]) {
                    k += a[i];
                    integers.add(a[i]);
                    ans++;
                }
                i ++;
            }
            if (k < a[i]) {
                System.out.println(-1);
                return;
            }
            Collections.sort(integers);
            long tmp = k;
            for (int j = 0; j < integers.size(); j++) {
                tmp-=integers.get(j);
                if (tmp < a[i]) {
                    tmp+=integers.get(j);
                    k = tmp;
                    break;
                }
                ans--;
            }
            k+=a[i];
            ans++;
        }
        System.out.println(ans);
    }
}
