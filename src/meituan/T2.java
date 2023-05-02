package meituan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (count <= K) {
                if (map.get(a[i]) != null) {
                    end++;
                    ret = Math.max(ret,end-start);
                }else {
                    Integer before = map.get(a[start]);
                    count ++;
                    end++;
                    if (count > K) {
                        if (before == null) {
                            start++;
                        }else {
                            start = before+1;
                        }
                        count--;
                    }
                    ret = Math.max(ret,end-start);
                }
            }
            map.put(a[i],i);
        }
        System.out.println(ret);
    }
}
