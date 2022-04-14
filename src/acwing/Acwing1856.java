package acwing;

import java.util.Scanner;
import java.util.function.IntFunction;

public class Acwing1856 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] before = new int[4];
        int[] after = new int[4];

        for (int i = 0; i < 4; i++) {
            before[i] = scanner.nextInt();
            after[i] = scanner.nextInt();
        }
        int[] ret = new int[3];
        int tem = 0;
        for (int i = 3; i >=0 ; i--) {
            if (i != 0) {

                ret[i-1] = after[i] + tem - before[i];
                tem = ret[i-1];
            }
        }
        for (int r :
                ret) {
            System.out.println(r);
        }
    }
}
