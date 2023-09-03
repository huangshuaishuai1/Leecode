package wx;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] candy = new int[n];

        for (int i = 0; i < n; i++) {
            candy[i] = scanner.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(candy[i])) {
                System.out.println(ans);
                return;
            }
            set.add(candy[i]);
            ans++;
        }
        System.out.println(ans);
    }
}
