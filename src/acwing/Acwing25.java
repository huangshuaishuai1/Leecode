package acwing;

import java.util.Scanner;

public class Acwing25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number % 3 == 0) {
            System.out.println((int) Math.pow(3,number/3));
        }else if (number % 3 == 1) {
            System.out.println((int) Math.pow(3,(number/3)-1)*2*2);
        }else {
            System.out.println((int) Math.pow(3,number/3)*2);
        }
    }
}
