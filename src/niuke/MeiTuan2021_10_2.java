package niuke;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MeiTuan2021_10_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        int ret = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        for (int i = 1; i <= n; i++) {
            ret += Math.abs(numbers[i-1] - i);
        }
        System.out.println(ret);
    }
}
