package graph;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T802 {
    public static void main(String[] args) {
        T802 t802 = new T802();
        int[][] graph = new int[5][];
        graph[0] = new int[]{};
        graph[1] = new int[]{0,2,3,4};
        graph[2] = new int[]{3};
        graph[3] = new int[]{4};
        graph[4] = new int[]{};
//        graph[5] = new int[]{};
//        graph[6] = new int[]{};
        List<Integer> integers = t802.eventualSafeNodes(graph);
        System.out.println(111);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> graphList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Integer> graphItem = new ArrayList<>();
            if (graph[i].length == 0) {
                queue.add(i);
                graphList.add(graphItem);
                continue;
            }
            for (int i1 : graph[i]) {
                graphItem.add(i1);
                ArrayList<Integer> arrayList = map.getOrDefault(i1, new ArrayList<>());
                arrayList.add(i);
                map.put(i1,arrayList);
            }
            graphList.add(graphItem);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (queue.size() != 0) {
            Integer top = queue.poll();
            ans.add(top);
            // 直接拿到map中key为top的
            ArrayList<Integer> list = map.getOrDefault(top,new ArrayList<>());
            for (Integer j : list) {
                graphList.get(j).remove(top);
                if (graphList.get(j).size() == 0) {
                    queue.add(j);
                }
            }
        }

        return ans.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }).collect(Collectors.toList());

    }
}
