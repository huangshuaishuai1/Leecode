package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing1761 {
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

        int x5 = scanner.nextInt();
        int y5 = scanner.nextInt();
        int x6 = scanner.nextInt();
        int y6 = scanner.nextInt();
        int sum = 0 ;
        sum += getArea(x1,y1,x2,y2);
        sum += getArea(x3,y3,x4,y4);
        sum -= getOverlap(x1,y1,x2,y2,x5,y5,x6,y6);
        sum -= getOverlap(x3,y3,x4,y4,x5,y5,x6,y6);
        System.out.println(sum);
    }

    public static int getArea(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (y2 - y1);
    }

    // 前两个坐标是广告牌，后两个坐标是车子
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
