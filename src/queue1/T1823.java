package queue1;

import java.util.LinkedList;
import java.util.Queue;

public class T1823 {

    public int findTheWinner(int n, int k) {
        Queue<Integer> integers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            integers.add(i);
        }
        while (integers.size() > 1) {
            for (int i = 0; i < k-1; i++) {
                integers.add(integers.poll());
            }
            integers.poll();
        }
        return integers.peek();
    }

    public static void main(String[] args) {
        T1823 t1823 = new T1823();
        System.out.println(t1823.findTheWinner(6, 5));
    }
}
