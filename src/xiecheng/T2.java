package xiecheng;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if (count == 1 || count == 0) {
            System.out.println(0);
            return;
        }
        int[] ints = new int[count];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <count; i++) {
            ints[i] = scanner.nextInt();
            min = Math.min(ints[i],min);
        }
        int ans = 0;

    }
}
