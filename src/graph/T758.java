package graph;

import java.util.ArrayDeque;
import java.util.HashSet;

public class T758 {

    public static void main(String[] args) {
        T758 t758 = new T758();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(t758.isBipartite(graph));
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int l = 0; l < graph.length; l++) {
            if (graph[l].length!=0 && color[l] == 0) {
                queue.add(l);
                color[l] = 1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        Integer poll = queue.poll();
                        int co = color[poll];
                        int[] node = graph[poll];
                        for (int j = 0; j < node.length; j++) {
                            if (color[node[j]] == 0) {
                                if (co == 1) {
                                    color[node[j]] = 2;
                                }else {
                                    color[node[j]] = 1;
                                }
                                queue.add(node[j]);
                            }else {
                                if (co == color[node[j]]) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

}
