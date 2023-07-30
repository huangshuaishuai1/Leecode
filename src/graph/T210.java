package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T210 {


    public static void main(String[] args) {
        T210 t210 = new T210();
        System.out.println(t210.findOrder(2, new int[][]{{1, 0}}));
        System.out.println(111);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int len = 0;
        int[] used = new int[numCourses];
        int[] out = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int o = prerequisite[0];
            int i = prerequisite[1];

            out[o]++;
            List<Integer> list = map.getOrDefault(i, new ArrayList<>());
            list.add(o);
            map.put(i, list);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (out[i] == 0) {
                queue.add(i);
                used[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                ans[len++] = poll;
                List<Integer> integers = map.get(poll);
                if (integers == null || integers.size() == 0)
                {
                    continue;
                }
                for (Integer integer : integers) {
                    out[integer]--;
                    if (out[integer] == 0 && used[integer] == 0) {
                        queue.add(integer);
                        used[integer] = 1;
                    }
                }
            }

        }
        for (int i = 0; i < numCourses; i++) {
            if (out[i] != 0) {
                return new int[]{};
            }
        }
        return ans;
    }
}
