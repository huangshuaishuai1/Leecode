package sxf;

import java.util.HashMap;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();

        for (int i = 0; i < loop; i++) {
            int n = scanner.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, Integer> map1 = new HashMap<>();
            int[][] a = new int[n][2];
            int p = 0;
            for (int j = 0; j < n; j++) {
                a[j][0] = scanner.nextInt();
                a[j][1] = scanner.nextInt();
//                if (a[j][1] == 0) {
//                    p = j+1;
//                }
                map.put(a[j][1],a[j][0]);
                map1.put(a[j][1],j+1);
            }
            for (int j = 0; j < n; j++) {
                System.out.print(map.get(p));
                System.out.print(" ");
                p = map1.get(p);
//                p = map.get(integer);
            }
        }
    }
}
