package graph;

import java.util.*;

public class T841 {

    public static void main(String[] args) {
        T841 t841 = new T841();
        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,3));
        list.add(Arrays.asList(1,4));
        list.add(Arrays.asList(2,3,4,1));
        list.add(Collections.emptyList());
        list.add(Arrays.asList(4,3,2));
        System.out.println(t841.canVisitAllRooms(list));
    }
    static int[] parent;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            Integer top = queue.poll();
            List<Integer> list = rooms.get(top);
            for (Integer integer : list) {
                if (!set.contains(integer)) {
                    queue.add(integer);
                    set.add(integer);
                    // 将这些作为0的儿子
                    parent[integer] = findParent(top);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (parent[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int findParent(int index) {
        if (parent[index] == index) {
            return parent[index];
        }
        parent[index] = parent[parent[index]];
        return parent[index];
    }

    public void union(int i, int j) {
        int low = Math.min(i,j);
        int high = Math.max(i,j);

        int lowParent = findParent(low);
        int highParent = findParent(high);
        parent[highParent] = lowParent;
    }
}
