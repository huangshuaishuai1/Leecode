package jd;

import java.util.Arrays;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] l = new int[3];
        int[] r = new int[3];

        for (int i = 0; i < 3; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            l[i] = Math.min(a,b);
            r[i] = Math.max(a,b);
        }

        // 排序
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 3; j++) {
                if (l[i] > l[j]) {
                    int temp = l[i];
                    l[i] = l[j];
                    l[j] = temp;
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                }
            }
        }

        if (l[1] > r[0] && l[2] > r[1]) {
            System.out.println(-1);
        }

        int rMax = 0;
        rMax = Math.max(r[0],r[1]);
        rMax = Math.max(rMax,r[2]);

        if (rMax == r[0]) {
            System.out.println(2 * Math.max(r[1],r[2]));
        }else if (rMax == r[1]) {
            System.out.println(2 * Math.max(r[0],r[2]));
        } else {
            System.out.println(2 * Math.max(r[0],r[1]));
        }
    }
}
