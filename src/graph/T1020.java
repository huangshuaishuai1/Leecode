package graph;

import java.util.ArrayDeque;

public class T1020 {
    public static void main(String[] args) {
        T1020 t1020 = new T1020();
        int[][] grid = {{0,0,0,1,1,1,0,1,1,1,1,1,0,0,0},{1,1,1,1,0,0,0,1,1,0,0,0,1,1,1},{1,1,1,0,0,1,0,1,1,1,0,0,0,1,1},{1,1,0,1,0,1,1,0,0,0,1,1,0,1,0},{1,1,1,1,0,0,0,1,1,1,0,0,0,1,1},{1,0,1,1,0,0,1,1,1,1,1,1,0,0,0},{0,1,0,0,1,1,1,1,0,0,1,1,1,0,0},{0,0,1,0,0,0,0,1,1,0,0,1,0,0,0},{1,0,1,0,0,1,0,0,0,0,0,0,1,0,1},{1,1,1,0,1,0,1,0,1,1,1,0,0,1,0}};
        System.out.println(t1020.numEnclaves(grid));
    }

    static int ans = 0;

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid,i,j);
                }
            }
        }
        return ans;
    }

    void bfs(int[][] grid, int dim1, int dim2) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int ret = 0;
        int flag = 0;
        grid[dim1][dim2] = 0;
        queue.add(new int[]{dim1,dim2});
        int[][] dirt = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()) {
            int sz = queue.size();
            ret+=sz;
            for (int i = 0; i < sz; i++) {
                int[] poll = queue.poll();
                int m = poll[0];
                int n = poll[1];

                for (int j = 0; j < 4; j++) {
                    if (m + dirt[j][0] < 0 || m + dirt[j][0] >= grid.length
                    || n + dirt[j][1] < 0 || n + dirt[j][1] >= grid[0].length) {
                        flag = 1;
                        continue;
                    }
                    if (grid[m + dirt[j][0]][n + dirt[j][1]] == 1) {
                        grid[m + dirt[j][0]][n + dirt[j][1]] = 0;
                        queue.add(new int[]{m + dirt[j][0],n + dirt[j][1]});
                    }
                }
            }
        }
        if (flag == 0) {
            ans+=ret;
        }
    }


}
