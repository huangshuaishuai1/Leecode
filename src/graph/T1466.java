package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class T1466 {

    public static void main(String[] args) {
        T1466 t1466 = new T1466();
        int[][] ints = new int[2][2];
        ints[0] = new int[]{1,0};
        ints[1] = new int[]{2,0};
//        ints[2] = new int[]{3,2};
//        ints[3] = new int[]{3,4};
//        ints[4] = new int[]{4,5};
        System.out.println(t1466.minReorder(3, ints));
    }
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> toDo = new HashMap<>();

        for (int[] connection : connections) {
            ArrayList<Integer> list = map.getOrDefault(connection[1], new ArrayList<>());
            list.add(connection[0]);
            map.put(connection[1],list);
            ArrayList<Integer> list1 = toDo.getOrDefault(connection[0], new ArrayList<>());
            list1.add(connection[1]);
            toDo.put(connection[0],list1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int ans = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ArrayList<Integer> list = map.getOrDefault(poll,new ArrayList<>());
            for (Integer integer : list) {
                queue.add(integer);
                ArrayList<Integer> list1 = toDo.getOrDefault(integer,new ArrayList<>());
                list1.remove(poll);
                toDo.put(integer,list1);
            }

            ArrayList<Integer> toDoOrDefault = toDo.getOrDefault(poll, new ArrayList<>());
            ans+=toDoOrDefault.size();
            queue.addAll(toDoOrDefault);
        }
        return ans;
    }
}
