package greedy;

import java.util.Arrays;

public class T435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 排序
        Arrays.sort(intervals,((o1, o2) ->  Integer.compare(o1[0],o2[0])));
        int count = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <end) {
                count++;
                end = Math.min(end,intervals[i][1]);
            }else {
                end = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        T435 t435 = new T435();
        System.out.println(t435.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
