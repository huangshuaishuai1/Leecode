package acwing;

import java.util.*;

public class acwing1671 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            ints[i][0] = scanner.nextInt();
            ints[i][1] = scanner.nextInt();
        }
        HashMap<Integer, List<Integer>> x_map = new HashMap<>();
        HashMap<Integer, List<Integer>> y_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tempx = ints[i][0];
            int tempy = ints[i][1];
            if (x_map.containsKey(tempx)) {
                List<Integer> listX = x_map.get(tempx);
                listX.add(tempy);
                Collections.sort(listX);
                x_map.put(tempx, listX);
            } else {
                List<Integer> listX = new ArrayList<>();
                listX.add(tempy);
                x_map.put(tempx, listX);
            }
            if (y_map.containsKey(tempy)) {
                List<Integer> listY = y_map.get(tempy);
                listY.add(tempx);
                Collections.sort(listY);
                y_map.put(tempy, listY);
            } else {
                List<Integer> listY = new ArrayList<>();
                listY.add(tempx);
                y_map.put(tempy, listY);
            }
        }
        int ret = 0;
        for (Integer key: x_map.keySet()) {
            List<Integer> integers = x_map.get(key);
            int len = integers.size();
            if (len >= 2) {
                int x1 = key;
                for (int i = 0; i < len; i++) {
                    int y1 = integers.get(i);
                    for (int j = i + 1; j < len; j++) {
                        int y2 = integers.get(j);
                        // 这里的x可能在中间，也可能在两边。
                        List<Integer> integers1 = y_map.get(y1);
                        int len1 = integers1.size();
                        if (len1 >= 2) {
                            int x2 = x1 - integers1.get(0) > integers1.get(len1 - 1) - x1 ?
                                    integers1.get(0) : integers1.get(len1 - 1);
                            ret = Math.max(ret, Math.abs((x2 - x1) * (y2 - y1)));
                        }
                        List<Integer> integers2 = y_map.get(y2);
                        int len2 = integers2.size();
                        if (len2 >= 2) {
                            int x2 = x1 - integers2.get(0) > integers2.get(len2 - 1) - x1 ?
                                    integers2.get(0) : integers2.get(len2 - 1);
                            ret = Math.max(ret, Math.abs((x2 - x1) * (y2 - y1)));
                        }
                    }
                }

            }
        }
        System.out.println(ret);
    }
}
