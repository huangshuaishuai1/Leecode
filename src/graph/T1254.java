package graph;

import java.util.ArrayDeque;

public class T1254 {

    public static void main(String[] args) {
        T1254 t1254 = new T1254();
        int[][] grid = {{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};
        System.out.println(t1254.closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                queue.add(new int[]{i,0});
                grid[i][0] = 1;
            }
            if (grid[i][grid[0].length-1] == 0) {
                queue.add(new int[]{i,grid[0].length-1});
                grid[i][grid[0].length-1] = 1;
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 0) {
                queue.add(new int[]{0,i});
                grid[0][i] = 1;
            }
            if (grid[grid.length-1][i] == 0) {
                queue.add(new int[]{grid.length-1,i});
                grid[grid.length-1][i] = 1;
            }
        }
        int[][] dirt = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    if (poll[0] + dirt[j][0] < 0 || poll[0] + dirt[j][0] >= grid.length
                    || poll[1] + dirt[j][1] < 0 || poll[1] + dirt[j][1] >= grid[0].length) {
                        continue;
                    }
                    if (grid[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] == 0) {
                        queue.add(new int[]{poll[0] + dirt[j][0],poll[1] + dirt[j][1]});
                        grid[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] = 1;
                    }
                }
            }
        }

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == 0) {
                    queue.add(new int[]{m,n});
                    grid[m][n] = 1;
                    ans++;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int i = 0; i < sz; i++) {
                            int[] poll = queue.poll();
                            for (int j = 0; j < 4; j++) {
                                if (poll[0] + dirt[j][0] < 0 || poll[0] + dirt[j][0] >= grid.length
                                        || poll[1] + dirt[j][1] < 0 || poll[1] + dirt[j][1] >= grid[0].length) {
                                    continue;
                                }
                                if (grid[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] == 0) {
                                    queue.add(new int[]{poll[0] + dirt[j][0],poll[1] + dirt[j][1]});
                                    grid[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
