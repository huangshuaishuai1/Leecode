package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T1557 {
    public static void main(String[] args) {
        T1557 t1557 = new T1557();
        int[][] a = {{0,1},{2,1},{3,1},{1,4},{2,4}};
        List<List<Integer>> collect = Arrays.stream(a).map(new Function<int[], List<Integer>>() {
            @Override
            public List<Integer> apply(int[] ints) {
                List<Integer> arrayList = new ArrayList<>();
                arrayList.add(ints[0]);
                arrayList.add(ints[1]);
                return arrayList;
            }
        }).collect(Collectors.toList());

        System.out.println(t1557.findSmallestSetOfVertices(5, collect));
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // 初始化
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> integers = edges.get(i);
            int a = integers.get(0);
            int b = integers.get(1);

            union(parent,a,b);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    // 找到node的父亲
    int findParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        int p = findParent(parent,parent[node]);
        return p;
    }

    // 合并
    void union(int[] parent,int lower, int higher) {

        parent[higher] = lower;
    }
}
