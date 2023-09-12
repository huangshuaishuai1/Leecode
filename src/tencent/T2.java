package tencent;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] b = new int[n-1];
            for (int j = 0; j < n; j++) {
                a.add(scanner.nextInt());
                map.put(j,a.get(j));
            }
            for (int j = 0; j < n - 1; j++) {
                b[j] = scanner.nextInt();
            }
            func(n,a,b,map);
        }
    }

    static void func(int n, ArrayList<Integer> a, int[] b, HashMap<Integer, Integer> map) {
        Collections.sort(a);
        List<String> strings = a.stream().map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        }).collect(Collectors.toList());
        int len = n;
        if (len % 2 == 0) {
            int aaa = a.get(len/2)+a.get(len/2-1);
            if (aaa%2==0) {
                System.out.print( aaa/2 + " ");
            }else {
                System.out.print( (double) aaa/2 + " ");
            }

        } else {
            System.out.print(a.get(len/2)+" ");
        }
        for (int i = 0; i < n-1; i++) {
            len--;
            int number = map.get(b[i]-1);
            strings.remove(String.valueOf(number));
            if (len % 2 == 0) {
                int ans = Integer.valueOf(strings.get(len/2))+Integer.valueOf(strings.get(len/2-1));
                if (ans%2==1) {
                    System.out.print((double)ans/2+" ");
                }else {
                    System.out.print(ans/2 +" ");
                }

            } else {
                System.out.print(Integer.valueOf(strings.get(len/2))+" ");
            }

        }
        System.out.println();
    }
}
