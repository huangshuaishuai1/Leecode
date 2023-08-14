package KDXF;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MHYT2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int ans = 1;
        int deep = 0;
        HashMap<Integer, ArrayList<Integer>> child = new HashMap<>();
        int[] isNotLeaf = new int[n+1];
        HashMap<Integer, Integer> itDeep = new HashMap<>();
        isNotLeaf[1] = 1;
        for (int i = 0; i < n - 1; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            ArrayList<Integer> list = child.getOrDefault(from, new ArrayList<>());
            list.add(to);
            child.put(from,list);
            isNotLeaf[from] = 1;
        }
        itDeep.put(1,0);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            if (deep == k) {
                break;
            }
            deep++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (isNotLeaf[poll] == 0) {
                    continue;
                }
                ArrayList<Integer> arrayList = child.get(poll);
                ans+=arrayList.size();
                for (Integer integer : arrayList) {
                    itDeep.put(integer,deep);
                    queue.add(integer);
                }
            }
        }
        for (int i = 2; i < n+1; i++) {
            if (isNotLeaf[i] == 0 && itDeep.getOrDefault(i,Integer.MAX_VALUE) < k) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
