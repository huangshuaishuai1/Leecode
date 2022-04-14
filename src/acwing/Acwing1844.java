package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing1844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int M = scanner.nextInt();

        int m = M / Y;
        int times = m;
        int n = 0;
        int[] max = new int[m+1];
        for (int i = 0; i <= times; i++) {
            n =(M - m * Y) / X;
            max[i] = n*X+m*Y;
            m--;
        }
        Arrays.sort(max);
        System.out.println(max[times]);
    }
}
