package meituan;

import java.util.Scanner;

public class Date202356T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] come = new int[n];
        int[] go = new int[n];

        for (int i = 0; i < n; i++) {
            come[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            go[i] = come[i] + scanner.nextInt();
        }

        int ans = 1;
        int time = come[0] + k;
        for (int i = 0; i < n; i++) {
            if (time < come[i]) {
                time = come[i];
            }
            if (time < go[i]) {
                ans++;
                time+=k;
            }
        }
        System.out.println(ans);
    }
}
