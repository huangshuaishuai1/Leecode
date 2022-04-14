package acwing;

import java.util.Scanner;

public class Acwing1775 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x == y) {
            System.out.println(0);
            return;
        }
        int count = 0;
        int times = 1;
        if (y > x) {
            while (true) {
                if (x + times >= y) {
                    count += (y-x);
                    System.out.println(count);
                    return;
                }else {
                    count += 2 * times;
                    times *= 2;
                    count += 2 * times;
                    times *= 2;
                }
            }
        }else {
            count += 2;
            times = 2;
            while (true) {

                if (x - times <= y) {
                    count += (x-y);
                    System.out.println(count);
                    return;
                }else {
                    count += 2* times;
                    times *= 2;
                    count += 2*times;
                    times *= 2;
                }
            }
        }
    }
}
