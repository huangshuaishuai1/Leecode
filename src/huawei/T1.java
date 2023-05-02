package huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[][] renwu = new int[number][2];
        int max = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < number; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
//            max = Math.max(max,b);
            renwu[i][0] = a;
            renwu[i][1] = b;
//            for (int j = a; j <= b; j++) {
//                if (map.containsKey(j)) {
//                    map.put(j,map.get(j)+1);
//                }else {
//                    map.put(j,1);
//                }
//            }
        }
        int ret = 0;
        Object[] objects = Arrays.stream(renwu).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        }).toArray();
        int l = 0;
        int r = 0;
        for (Object object : objects) {
            int[] a = (int[]) object;

            if (a[0] > r) {

            }
        }


        System.out.println(ret);
    }
}
