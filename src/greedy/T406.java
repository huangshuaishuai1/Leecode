package greedy;


import java.util.*;

public class T406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) {
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];

            }
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            que.add(people[i][1],people[i]);
        }
        int[][] ret = que.toArray(new int[people.length][]);
        return ret;
    }

    public static void main(String[] args) {
        T406 t406 = new T406();
        int[][] ints = t406.reconstructQueue(new int[][]{{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}});
        System.out.println("111");
    }
}
