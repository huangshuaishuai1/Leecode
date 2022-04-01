package acwing;

import java.util.Scanner;

public class Acwing1737 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (a > b) {
            if ((x <= b && y <= b) || (x >= a && y >=a)){
                System.out.println(a - b);
            }else {
                int ret = Math.abs(b - Math.min(x, y)) + Math.abs(a - Math.max(x, y));
                System.out.println(Math.min(a - b, ret));
            }
        }
        else {
            if ((x <= a && y <= a) || (x >= b && y >= b)) {
                System.out.println(b - a);
            } else {
                int ret = Math.abs(a - Math.min(x,y)) + Math.abs(b - Math.max(x,y));
                System.out.println(Math.min(ret, b-a));
            }
        }
    }
}
