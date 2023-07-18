package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class T997 {

    public static void main(String[] args) {
        T997 t997 = new T997();
        int[][] trust = {{1,2}};
        System.out.println(t997.findJudge(2, trust));
    }

    public int findJudge(int n, int[][] trust) {
        ArrayList<HashSet<Integer>> arrayLists = new ArrayList<>();
        ArrayList<HashSet<Integer>> arrayLists1 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
//            set.add(i);
            arrayLists.add(set);
            arrayLists1.add(new HashSet<>());
        }
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            arrayLists.get(b-1).add(a-1);
            arrayLists1.get(a-1).add(b-1);
        }

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = arrayLists.get(i);
            if (set.size() == n-1 && !set.contains(i) && arrayLists1.get(i).size() == 0) {
                return i+1;
            }
        }
        return -1;
    }


}
