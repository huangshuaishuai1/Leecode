package zj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, PriorityQueue<Integer>> a = new HashMap<>();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            PriorityQueue<Integer> queue = a.getOrDefault(tmp, new PriorityQueue<>());
            queue.add(tmp);
            a.put(tmp,queue);
        }
        for (int i = 0; i <n; i++) {
            b[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[] x = new int[q];

        int ans = n;
        for (int i = 0; i < n; i++) {
            int h = b[i];
            if (!a.containsKey(h)){
                continue;
            }
            ans--;
            PriorityQueue<Integer> queue = a.get(h);
            Integer poll = queue.poll();
            ans += poll;
            if (h % poll == 0) {
                PriorityQueue<Integer> queue1 = a.getOrDefault(h / poll, new PriorityQueue<>());
                for (int j = 0; j < poll; j++) {
                    queue1.add(poll);
                }
            } else {
                int gap = h - h/poll;
                PriorityQueue<Integer> queue1 = a.getOrDefault(h / poll, new PriorityQueue<>());
                PriorityQueue<Integer> queue2 = a.getOrDefault(h / poll+1, new PriorityQueue<>());
                for (int j = 0; j < poll-gap; j++) {
                    queue1.add(poll);
                }
                for (int j = 0; j < gap; j++) {
                    queue2.add(poll);
                }
            }

        }
        System.out.println(ans);
    }
}
