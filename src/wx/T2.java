package wx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        int ret = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            Integer count = map.getOrDefault(a[i], 0);
            count++;
            map.put(a[i],count);
        }
        Arrays.sort(a);
        System.out.println(helper(a, map));
    }
    public static int helper (int[] a, HashMap<Integer, Integer> map) {
        int n = a.length;
        int ret = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i-1]) {
                continue;
            }
            int now = a[i];
            Integer aa = map.get(a[i]);
            aa--;
            ret += aa;
            Integer orDefault = map.getOrDefault(a[i] + 1, 0);
            orDefault+=aa;
            map.put(a[i]+1,orDefault);
            for (int j = i; j < i+aa; j++) {
                a[j] = now+1;
            }
        }
        return ret;
    }
}
