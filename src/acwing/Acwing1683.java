package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing1683 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] positions = new int[3];
        positions[0] = scanner.nextInt();
        positions[1] = scanner.nextInt();
        positions[2] = scanner.nextInt();
        Arrays.sort(positions);
        if (positions[1] - positions[0] == 1 && positions[2] - positions[1] == 1){
            System.out.println(0);
            System.out.println(0);
            return;
        }
        int min = 0;
        if (positions[1] - positions[0] == 2 || positions[2] - positions[1] == 2) {
            min = 1;
        }else {
            min = 2;
        }
        int max = Math.max(positions[2] - positions[1],positions[1] - positions[0]);
        System.out.println(min);
        System.out.println(max);
    }
}
