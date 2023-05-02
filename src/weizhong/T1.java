package weizhong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            c[i] = a[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            map.put(a[i], b[i]);
        }

        HashMap<Integer, Integer> res = new HashMap<>();
        Arrays.sort(a);
        res.put(a[0],0);
        int tmp = 0;
        for (int i = 1; i <= m; i++) {
            tmp = 0;
            for (int j = i-1; j >=0; j--) {
                tmp += map.get(a[j]);
            }
            res.put(a[i], tmp);
        }
        for (int i = m+1; i < n; i++) {
            tmp -= map.get(a[i-m-1]);
            tmp += map.get(a[i-1]);
            res.put(a[i],tmp);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res.get(c[i])+" ");
        }
    }
}
