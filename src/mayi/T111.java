package mayi;

import java.util.HashMap;
import java.util.Scanner;

public class T111 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            Integer count = map.getOrDefault(a[i], 0);
            count++;
            map.put(a[i],count);
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
            Integer count = map1.getOrDefault(b[i], 0);
            count++;
            map1.put(b[i],count);
        }
        int ans = 0;
        int p1 = map1.get(1);
        int p2 = map1.get(2);

        int c1 = map.get(1);
        int c2 = map1.get(2);

        int c22 = Math.max(0,c2-2*(p2));
        ans += c2-c22;
        int c11 = c1;
        if (c22 == 0) {
            int tmp = c2 / 2;
            c2 -= tmp;
            tmp = c2 % 2;
            if (tmp == 0) {
                c11 = Math.max(0,c1-3*(2*(p2)-c2));
                ans += c1- c11;
            } else {
                ans++;
                c11 = Math.max(0,c1-3*(2*(p2)-c2-1));
                ans += c1- c11;
            }
        }
        if (c11 == 0) {
            System.out.println(ans);
            return;
        }
        int c111 = Math.max(0,c11-2*(p1));
        ans += c11- c111;
        if (2*(p1) - c11 > 0 && c22 > 0) {
            ans += c22 - Math.max(0,c22-2*(p1) - c11);
        }
        System.out.println(ans);
    }
}
