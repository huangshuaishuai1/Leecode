package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing1812 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        int[] X = new int[4];
        X[0] = x1;
        X[1] = x2;
        X[2] = x3;
        X[3] = x4;

        int[] Y = new int[4];
        Y[0] = y1;
        Y[1] = y2;
        Y[2] = y3;
        Y[3] = y4;

        Arrays.sort(X);
        Arrays.sort(Y);

        System.out.println( (Math.max(X[3] - X[0], Y[3]-Y[0]) * Math.max(X[3] - X[0], Y[3]-Y[0])));

    }
}
