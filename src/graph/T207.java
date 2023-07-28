package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class T207 {
    public static void main(String[] args) {
        T207 t207 = new T207();
        System.out.println(t207.canFinish(2, new int[][]{{1,0},{0,1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        int[] outDeg = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            outDeg[prerequisite[0]]++;
            inDeg[prerequisite[1]]++;
            ArrayList<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1],list);
        }
        int[] used = new int[numCourses];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (outDeg[i] == 0) {
                queue.add(i);
                used[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Integer poll = queue.poll();
                ArrayList<Integer> list = map.get(poll);
                if (list == null || list.size() == 0)
                {
                    continue;
                }
                for (Integer integer : list) {
                    outDeg[integer]--;
                    if (outDeg[integer] == 0) {
                        queue.add(integer);
                        used[integer]=1;
                    }
                }
            }
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0) {
                return false;
            }
        }
        return true;
    }


}
