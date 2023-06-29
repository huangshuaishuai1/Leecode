package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T797 {
    static List<List<Integer>> ans;
    static ArrayList<Integer> list;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(i, new ArrayList<>());
            for (int g : graph[i]) {
                list.add(g);
            }
            map.put(i,list);
        }

        // dfs
        ans = new ArrayList<List<Integer>>();
        list = new ArrayList<>();
        list.add(0);
        dfs(map,0);
        return ans;
    }

    static void dfs(HashMap<Integer, ArrayList<Integer>> map, int index) {
        if (map.size() == index+1) {
            ans.add(new ArrayList<>(list));
            return;
        }
        ArrayList<Integer> nodes = map.get(index);
        if (nodes.size() == 0) {
            return;
        }
        for (int i = 0; i < nodes.size(); i++) {
            list.add(nodes.get(i));
            dfs(map,nodes.get(i));
            list.remove(nodes.get(i));
        }
    }

    public static void main(String[] args) {
        T797 t797 = new T797();
        int[][] dp = new int[5][];
        dp[0] = new int[]{4,3,1};
        dp[1] = new int[]{3,2,4};
        dp[2] = new int[]{3};
        dp[3] = new int[]{4};
        dp[4] = new int[]{};
        System.out.println(t797.allPathsSourceTarget(dp));
    }

}
