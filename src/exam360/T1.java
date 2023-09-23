package exam360;

import java.util.HashSet;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] feature = new int[n];
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            feature[i] = scanner.nextInt();
            if (!set.contains(feature[i])) {
                set.add(feature[i]);
            }else {
                ans++;
            }
        }
        System.out.println(ans);


    }
}
