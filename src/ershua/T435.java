package ershua;

import java.util.Arrays;
import java.util.Comparator;

public class T435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2 [1];
                }
            }
        });
        int count = 0;
        int tag = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[tag][0]) {
                count ++;
                continue;
            }
            if (intervals[i][0] >= intervals[tag][1]) {
                tag = i;
                continue;
            }
            if (intervals[i][0] < intervals[tag][1]) {
                if (intervals[i][1] < intervals[tag][1]) {
                    tag = i;
                }
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        T435 t435 = new T435();
        int i = t435.eraseOverlapIntervals(new int[][]{
                {-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}
        });
        System.out.println(i);
    }
}
