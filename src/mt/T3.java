package mt;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            max = Math.max(max,numbers[i]);
        }
        int a = numbers[0];
        int ans = 0;
        while (a < max) {
            ans ++;
            int tmp = max / 2;
            if (a >= max - tmp) {
                a *= 2;
            }else {
                max /= 2;
            }
        }
        System.out.println(ans);
    }
}
