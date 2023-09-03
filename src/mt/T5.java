package mt;

import java.util.*;

public class T5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int c = scanner.nextInt();
            Integer number = map.getOrDefault(c, 0);
            number++;
            map.put(c,number);
        }
        HashMap<Integer, List<Integer>> map1 = new HashMap<>();
        Set<Integer> keySet = map.keySet();
        for (Integer integer : keySet) {
            Integer count = map.get(integer);
            List<Integer> list = map1.getOrDefault(count, new ArrayList<>());
        }
        int ans = 0;


    }
}
