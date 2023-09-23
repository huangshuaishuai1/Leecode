package exam360;

import java.util.HashMap;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long [] a = new long[n];
        long [] b = new long[n];
        int [] x = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            x[i] = scanner.nextInt();
            max = Math.max(max,b[i]);
        }
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long l = a[i];
            long r = b[i];
            int tmp = x[i];
            for (long j = l; j <= r; j++) {
                Long orDefault = map.getOrDefault(j, 0L);
                orDefault^=tmp;
                map.put(j,orDefault);
            }
        }
        for (int i = 0; i < m; i++) {
            long tmp = scanner.nextLong();
            if (map.containsKey(tmp)) {
                System.out.println(map.get(tmp));
            }else {
                System.out.println(0);
            }
        }
    }
}
