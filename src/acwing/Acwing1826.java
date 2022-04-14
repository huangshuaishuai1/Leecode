package acwing;

import java.util.*;

public class Acwing1826 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N =scanner.nextInt();
        int K = scanner.nextInt();
        HashMap<Integer, Integer> diamonds = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int size = scanner.nextInt();
            if (diamonds.containsKey(size)) {
                diamonds.put(size, diamonds.get(size) + 1);
            }else {
                diamonds.put(size,1);
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int center:
             diamonds.keySet()) {
            int sup = center + K;
            int sub = center - K;
            int count1 = 0;
            int count2 = 0;
            for (int tempKey:
                 diamonds.keySet()) {
                if (tempKey <= sup && tempKey >= center) {
                    count1 += diamonds.get(tempKey);
                }
                if (tempKey <= center && tempKey >= sub) {
                    count2 += diamonds.get(tempKey);
                }
            }
            ret.add(Math.max(count1,count2));
        }

        Collections.sort(ret);
        Integer integer = ret.get(ret.size()-1);
        System.out.println(integer);
    }
}
