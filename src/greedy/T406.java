package greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class T406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];

            }
        });
        int[][] ret = new int[people.length][2];
        for (int i = 0; i < ret.length; i++) {
            Arrays.fill(ret[i],-1);
        }
        for (int i = 0; i < people.length; i++) {
            int num = people[i][0];
            int pos = people[i][1];
            // 判断pos前面被占了几个位置
            int count = 0;
            for (int j = 0; j <= pos; j++) {
                if (ret[j][1] != -1 && ret[j][0] < num) {
                    count++;
                }
            }
            for (int j = pos; j < people.length; j++) {
                if (ret[j][1] == -1) {
                    if (count == 0) {
                        ret[j] = people[i];
                        break;
                    }else {
                        count--;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T406 t406 = new T406();
        int[][] ints = t406.reconstructQueue(new int[][]{{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}});
        System.out.println("111");
    }
}
