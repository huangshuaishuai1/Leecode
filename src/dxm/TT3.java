package dxm;

import java.util.*;

public class TT3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int M = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> child = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int p = scanner.nextInt();
            ArrayList<Integer> list = child.getOrDefault(p, new ArrayList<>());
            parent.put(i+1,p);
            list.add(i+2);
            child.put(p,list);
        }
        int ans = 0;
        int[] H = new int[n + 1];
        Queue<Integer> used = new ArrayDeque<>();
        Set<Integer> keySet = child.keySet();
        for (int i = 0; i < n; i++) {
            if (!keySet.contains(i+1)) {
                H[i+1] = 0;
                used.add(i+1);
            }
        }
        while (used.size()!=0) {
            Integer poll = used.poll();
            Integer integer = parent.get(poll);
            H[integer] += ((H[poll] + A) * B) % M;
        }
        System.out.println(H[1]);
    }
}
