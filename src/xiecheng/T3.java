package xiecheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(i,0);
        }
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            map.put(v % k, map.get(v%k)+1);
        }
        if (k == 3) {
            System.out.println(map.get(0) + Math.min(map.get(1),map.get(2)));
            return;
        }
        for (int i = 1; i < k / 2; i++) {
            ans += Math.min(map.get(i),map.get(k-i));
        }
        if (k %2 == 0) {
            ans += map.get(k /2 )/2;
        }
        System.out.println(ans);

    }
}
