package graph;

import java.util.*;

public class T1129 {
    public static void main(String[] args) {
        T1129 t1129 = new T1129();
        int[][] redEdges = new int[4][2];
        redEdges[0] = new int[]{0, 1};
        redEdges[1] = new int[]{1, 2};
        redEdges[2] = new int[]{2, 3};
        redEdges[3] = new int[]{3, 4};
        int[][] blueEdges = new int[3][2];
        blueEdges[0] = new int[]{1, 2};
        blueEdges[1] = new int[]{2, 3};
        blueEdges[2] = new int[]{3, 1};
        int[] ints = t1129.shortestAlternatingPaths(5, redEdges, blueEdges);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] stepTwo = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(stepTwo[i], Integer.MAX_VALUE);
        }
        HashMap<Integer, ArrayList<Integer>> redMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> blueMap = new HashMap<>();
        for (int i = 0; i < redEdges.length; i++) {
            ArrayList<Integer> list = redMap.getOrDefault(redEdges[i][0], new ArrayList<Integer>());
            if (!list.contains(redEdges[i][1])) {
                list.add(redEdges[i][1]);
            }
            redMap.put(redEdges[i][0], list);
        }
        for (int i = 0; i < blueEdges.length; i++) {
            ArrayList<Integer> list = blueMap.getOrDefault(blueEdges[i][0], new ArrayList<Integer>());
            if (!list.contains(blueEdges[i][1])) {
                list.add(blueEdges[i][1]);
            }
            blueMap.put(blueEdges[i][0], list);
        }
        stepTwo[0][0] = 0;
        stepTwo[0][1] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        int[][] used = new int[n][2];
        used[0][0] = 1;
        used[0][1] = 1;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ArrayList<Integer> list = redMap.get(poll);
            if (list != null) {
                for (int i1 : list) {

                    if (stepTwo[poll][1] != Integer.MAX_VALUE) {
                        if (used[i1][0] != 1) {
                            queue.add(i1);
                            used[i1][0] = 1;
                        }
                        stepTwo[i1][0] = Math.min(stepTwo[poll][1] + 1, stepTwo[i1][0]);
                    }

                }
            }
            ArrayList<Integer> list1 = blueMap.get(poll);
            if (list1 != null) {


                for (int i1 : list1) {

                    if (stepTwo[poll][0] != Integer.MAX_VALUE) {
                        if (used[i1][1] != 1 ) {
                            queue.add(i1);
                            used[i1][1] = 1;
                        }
                        stepTwo[i1][1] = Math.min(stepTwo[poll][0] + 1, stepTwo[i1][1]);
                    }
                }
            }
        }

        int[] ans = new int[n];
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            if (stepTwo[i][0] == Integer.MAX_VALUE && stepTwo[i][1] == Integer.MAX_VALUE) {
                ans[i] = -1;
                continue;
            }
            ans[i] = Math.min(stepTwo[i][0], stepTwo[i][1]);
        }
        return ans;
    }
}
