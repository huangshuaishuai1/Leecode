package bd;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            map.put(a[i],i);
        }
        HashMap<Integer,Integer> mapp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            mapp.put(i+1,i+1);
        }
        // 滑动窗口
        for (int z = 0; z < k; z++) {
            int oneIdx = map.get(z+1);
            for (int i = oneIdx; i >= Math.max(0,oneIdx-k+1); i--) {
                if (i > n-k+1) {
                    continue;
                }
                HashMap<Integer, Integer> map1 = new HashMap<>(mapp);
                int tag = 0;
                for (int j = i; j < Math.min(n,i+k); j++) {
                    if (a[j] >=1 && a[j] <= k) {
                        map1.remove(a[j]);
                    }else {
                        tag = j;
                    }
                }
                if (map1.size() == 1 || map1.size()==0) {
                    System.out.println("YES");
                    if (map1.size()==0) {
                        System.out.println(0);
                    }else {
                        System.out.println(1);
                        Set<Integer> keySet = map1.keySet();
                        Object[] array = keySet.toArray();
                        List<Integer> collect = Arrays.stream(array).map(new Function<Object, Integer>() {
                            @Override
                            public Integer apply(Object o) {
                                return (Integer) o;
                            }
                        }).collect(Collectors.toList());
                        Integer aa = map.get(collect.get(0)) + 1;
                        Integer bb = tag + 1;
                        Integer min = Math.min(aa,bb);
                        Integer max = Math.max(aa,bb);
                        System.out.print(min+" ");
                        System.out.print(max);
                    }
                    return;
                }
            }
        }


        System.out.println("NO");
    }
}
