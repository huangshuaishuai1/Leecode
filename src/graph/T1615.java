package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;

public class T1615 {
    public static void main(String[] args) {
        T1615 t1615 = new T1615();
        int[][] roads  = {{0, 1},{0, 3},{1, 2},{1, 3}};
        System.out.println(t1615.maximalNetworkRank(4, roads));
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<HashSet<Integer>> set = new ArrayList<>();

        ArrayList<int[]> sort = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int[] ints = {i, 0};
            sort.add(i,ints);
            set.add(new HashSet<>());
        }
        for (int i = 0; i < roads.length; i++) {
            sort.get(roads[i][0])[1]++;
            sort.get(roads[i][1])[1]++;
            set.get(roads[i][0]).add(roads[i][1]);
            set.get(roads[i][1]).add(roads[i][0]);
        }
        sort.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o2[1]-o1[1];
            }
        });

        int max = sort.get(0)[1];
        int one = sort.get(0)[0];
        int second = sort.get(1)[1];
        int i = 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (second == max) {
            for (int j = 0; j <sort.size(); j++) {
                if (sort.get(j)[1] == max) {
                    arrayList.add(sort.get(j)[0]);
                }
            }
            for (int j = 0; j < arrayList.size(); j++) {
                for (int k = j+1; k < arrayList.size(); k++) {
                    if (!set.get(arrayList.get(j)).contains(arrayList.get(k))) {
                        return 2*max;
                    }
                }
            }
        }else {
            while (i < sort.size() && sort.get(i)[1] == second) {
                int tmp = sort.get(i)[1];
                int two = sort.get(i)[0];
                if (!set.get(one).contains(two)) {
                    return max+tmp;
                }
                i++;
            }
        }
        return max+second-1;
    }
}
