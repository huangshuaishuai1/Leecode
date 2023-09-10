package didi;

import java.util.Scanner;

public class D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 种类数
        int a = scanner.nextInt();  // a包
        int b = scanner.nextInt();  // 最小b个

        int[] c = new int[n];
        int[] ac = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        int ans = 0;
        int count = 0;
        while (count < a) {
            ans++;
            for (int i = 0; i < n; i++) {
                int tmp = ac[i] + c[i];
                if (tmp >= b) {
                    count++;
                }
                ac[i] = tmp % b;
            }
        }
        System.out.println(ans);

    }
}
