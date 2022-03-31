package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing1749 {
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

        if (x3 <= x1 && y3 <= y1 && x4 >= x2 && y4 >= y2) {
            System.out.println(0);
        } else if ((x3 <= x2 && x3 >= x1 && x4 >= x2 && y4 >= y2 && y3 <= y1)
         || (y4 >= y2 && x4<=x2 && x4>=x1 && x3<=x1 && y3 <=y1)
                || (x4 >= x2 && y4 >= y2 && x3 <= x1 && y3 >= y1 && y3 <= y2)
        ||(x3 <= x1 && y3 <= y1 && x4 >= x2 && y4 >= y1 && y4 <= y2)) {
            int overlap = getOverlap(x1, y1, x2, y2, x3, y3, x4, y4);
            System.out.println(getArea(x1,y1,x2,y2) - overlap);
        } else {
            System.out.println(getArea(x1,y1,x2,y2));
        }
    }

    public static int getArea(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (y2 - y1);
    }

    public static int getOverlap (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // 如果不相交 返回 0
        if (x3 >= x2 || y3 >= y2 || y4 <= y1 || x4<= x1) {
            return 0;
        }
        int[] X = new int[4];
        int[] Y = new int[4];
        X[0] = x1;
        X[1] = x2;
        X[2] = x3;
        X[3] = x4;
        Y[0] = y1;
        Y[1] = y2;
        Y[2] = y3;
        Y[3] = y4;
        Arrays.sort(X);
        Arrays.sort(Y);
        return (X[2] - X[1]) * (Y[2] - Y[1]);
    }

}
