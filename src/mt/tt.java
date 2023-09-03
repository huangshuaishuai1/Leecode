package mt;

import java.util.HashSet;
import java.util.Scanner;

public class tt {
    final static long plot = 666L;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (arr.length < 2) {
            System.out.println(0);
        }
        int tag = 0;
        int ans = 0;
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                long c = arr[i] * plot + arr[j];
                long d = arr[j] * plot + arr[i];
                if (!set.contains(c) && !set.contains(d)) {
                    set.add(c);
                    set.add(d);
                    ans ++;
                    if (ans >= n /2) {
                        tag = 1;
                        break;
                    }
                }

            }
            if (tag == 1) {
                break;
            }
        }
        System.out.println(Math.max(1,Math.min(ans,n/2)));
    }
}
