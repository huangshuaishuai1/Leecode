package xm;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] task = new int[n][n];

        int[] de = new int[n];

        scanner.nextLine();
        String str = scanner.next();

        String[] split = str.split(",");

        for (String s : split) {
            String[] split1 = s.split(":");
            task[Integer.valueOf(split1[0])][Integer.valueOf(split1[1])] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (task[j][i] == 1) {
                    int c = -1;
                    de[i]++;
                }
            }
        }
        int p = -1;
        for (int i = 0; i < de.length; i++) {
            if (de[i] == 0) {
                p = i;
                break;
            }
        }

        if (p == -1) {
            System.out.println(0);
            return;
        }
        int ccc= 100;
        int count = 0;
        while (p != -1) {
            count++;
            de[p] = -1;
            for (int i = 0; i < n; i++) {
                if (task[p][i] > 0) {
                    de[i]--;
                }
                ccc++;
            }
            p = -1;
            for (int i = 0; i < de.length; i++) {
                if (de[i] == 0) {
                    p = i;
                    ccc++;
                    break;
                }
            }
        }

        if (count < n) {
            System.out.println(0);
        }else {
            System.out.println(1);
        }
    }
}
