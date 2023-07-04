package graph;

import java.util.ArrayDeque;

public class T1306 {

    public static void main(String[] args) {
        T1306 t1306 = new T1306();
        System.out.println(t1306.canReach(new int[]{3,0,2,1,2}, 2));
    }
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        if (arr.length == 1 && arr[0]==0) {
            return true;
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start,arr[start]});

        int used[] = new int[arr.length];
        used[start] = 1;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] poll = queue.poll();
                if (poll[0] - poll[1] >= 0 && used[poll[0] - poll[1]] == 0) {
                    if (arr[poll[0] - poll[1]] == 0) {
                        return true;
                    }
                    queue.add(new int[]{poll[0] - poll[1],arr[poll[0] - poll[1]]});
                    used[poll[0] - poll[1]] = 1;
                }
                if (poll[0] + poll[1] < used.length && used[poll[0] + poll[1]] == 0) {
                    if (arr[poll[0] + poll[1]] == 0) {
                        return true;
                    }
                    queue.add(new int[]{poll[0] + poll[1],arr[poll[0] + poll[1]]});
                    used[poll[0] + poll[1]] = 1;
                }
            }

        }
        return false;
    }
}
