package ershua;

import java.util.Arrays;
import java.util.Comparator;

public class T452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end){
                end = points[i][1];
                count ++;
            } else if (points[i][1] <= end) {
                end = points[i][1];
            }

        }
        return count + 1;
    }

    public static void main(String[] args) {
        T452 t452 = new T452();
        int minArrowShots = t452.findMinArrowShots(new int[][]{{-2147483646,-2147483645}, {2147483646,2147483647}});
        System.out.println( minArrowShots);
    }
}
