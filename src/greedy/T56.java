package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class T56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> retArray = new ArrayList<>();
        int low = intervals[0][0];
        int high = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= high) {
                if (intervals[i][1] > high) {
                    high = intervals[i][1];
                }
            }else {
                int[] ints = {low, high};
                retArray.add(ints);
                low = intervals[i][0];
                high = intervals[i][1];
            }
        }
        retArray.add(new int[]{low,high});
        int[][] ret = retArray.toArray(new int[0][0]);
        return ret;
    }

    public static void main(String[] args) {
        T56 t56 = new T56();
        int [][] intervals = new int[][] {{1,3},{8,10},{2,6},{15,18}};
        System.out.println(t56.merge(intervals));
    }
}
