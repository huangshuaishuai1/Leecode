package elm;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int[][] edge = new int[m][3];
        for (int i = 0; i < m; i++) {
            edge[i][0] = scanner.nextInt();
            edge[i][1] = scanner.nextInt();
            edge[i][2] = scanner.nextInt();
        }


    }
}
