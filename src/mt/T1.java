package mt;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n-1];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (i > 0 && a[i] <= a[i-1]) {
                System.out.println("NO");
                return;
            }
            if (i > 0) {
                int j = i-1;
                b[j] = a[j+1] - a[j];
                if (j > 0 && b[j] >= b[j-1]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

    }
}
