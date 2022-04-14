package acwing;

import java.util.Scanner;

public class Acwing1866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        if (b <= c || d <= a) {
            System.out.println(b-a+d-c);
        }else {
            int max = Math.max(b,d);
            int min = Math.min(a,c);
            System.out.println(max - min);
        }

    }
}
