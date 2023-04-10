package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class Meituan2021_10_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }

        Arrays.sort(scores);

        for (int i = x; i <= y; i++) {
            int m = scores[i-1];
            int noPass = i;
            for (int j = i; j <= y; j++) {
                if (scores[j] == m) {
                    noPass++;
                }else {
                    break;
                }
            }
            if (noPass <= y && n-noPass >= x && n-noPass <= y) {
                System.out.println(m);
                return;
            }
        }
        System.out.println(-1);
    }

}
