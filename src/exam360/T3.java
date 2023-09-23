package exam360;

import java.util.HashMap;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [] a = new int[n];
        int [] b = new int[n];
        int [] x = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            x[i] = scanner.nextInt();
            max = Math.max(max,b[i]);
        }
        int[] arr = new int[1000000000];
        int[] prefixArr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int l = a[i];
            int r = b[i];
            int tmp = x[i];
            for (int j = l; j <= r; j++) {
                arr[j] ^= tmp;
                prefixArr[0] = arr[0];
                for (int k = 1; k < arr.length; k++) {
                    prefixArr[k] = prefixArr[k-1] ^ arr[k];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int tmp = scanner.nextInt();
            System.out.println(prefixArr[tmp]);
        }
    }
}
