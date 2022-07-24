package greedy;


import java.util.Arrays;

public class T452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(o1,o2)-> Integer.compare(o1[0],o2[0]));

        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i-1][1]) {
                count++;
            }else {
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        T452 t452 = new T452();
        System.out.println(t452.findMinArrowShots(new int[][]{{-1, 1}, {0, 1}, {2,3}, {1, 2}}));
    }
}
