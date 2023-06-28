package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class T1376 {
    public static void main(String[] args) {
        T1376 t1376 = new T1376();
        System.out.println(t1376.numOfMinutes(11, 4, new int[]{5,9,6,10,-1,8,9,1,9,3,4}, new int[]{0,213,0,253,686,170,975,0,261,309,337}));
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 0) {
            return 0;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i],list);
        }

        int ans = 0;
        if (n == 1) {
            return 0;
        }
        ans = toChild(headID,map,informTime);

        return ans + informTime[headID];
    }

    static int toChild(Integer headId, HashMap<Integer,ArrayList<Integer>> map, int[] informTime) {
        if (informTime[headId] == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        ArrayList<Integer> child = map.get(headId);
        for (Integer integer : child) {
            ans = Math.max(informTime[integer]+toChild(integer,map,informTime),ans);
        }

        return ans;
    }
}
