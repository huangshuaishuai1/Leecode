package csp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class T1_2022_3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vNum = scanner.nextInt();
        int t = scanner.nextInt();
        HashSet<Integer> integers = new HashSet<>();
        int[] num = new int[t];
        int ret = 0;
        for (int i = 0; i < t; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if (!integers.contains(right) && right != 0) {
                ret++;
            }
            integers.add(left);
        }
        System.out.println(ret);
    }
}
