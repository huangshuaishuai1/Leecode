package mihayou;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            sumA+=a[i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            sumB+=b[i];
        }
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sumA-=a[i];
            ans = Math.max(ans,sumA^sumB);
            sumA+=a[i];
        }
        for (int i = 0; i < n; i++) {
            sumB-=b[i];
            ans = Math.max(ans,sumA^sumB);
            sumB+=b[i];
        }
        System.out.println(ans);
    }

}
