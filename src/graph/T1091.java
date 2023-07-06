package graph;

import java.util.ArrayDeque;

public class T1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] used = new int[grid.length][grid[0].length];
        if (grid[0][0] != 0) {
            return -1;
        }
        if (grid.length == 1 && grid[0].length == 1) {
            return 1;
        }
        // 八个方向
        int[][] dirt = {{-1,-1},{0,-1},{1,-1}, {0,1},{1,0},{1,1},{-1,1},{-1,0}};
        used[0][0] = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            ans++;
            for (int i = 0; i < sz; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 8; j++) {
                    if (poll[0] + dirt[j][0] >= grid[0].length || poll[1] + dirt[j][1] >= grid.length
                    || poll[0] + dirt[j][0]  < 0 || poll[1] + dirt[j][1] < 0) {
                        continue;
                    }
                    if (grid[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] == 0 && used[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] != 1) {
                        queue.add(new int[]{poll[0] + dirt[j][0],poll[1] + dirt[j][1]});
                        used[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] = 1;
                        if (poll[0] + dirt[j][0] == grid.length-1 && poll[1] + dirt[j][1] == grid[0].length-1) {
                            return ans +1 ;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
