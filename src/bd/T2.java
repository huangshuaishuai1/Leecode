package bd;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n==2&&m==2) {
                System.out.println("No");
            }else if ((n-1)%2 != (m-1) %2) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
