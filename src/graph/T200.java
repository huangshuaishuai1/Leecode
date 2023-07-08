package graph;

import java.util.ArrayDeque;

public class T200 {
    public static void main(String[] args) {

    }

    // 广度优先超时
    public int numIslands1(char[][] grid) {
        int ans = 0;
        int[][] dirt = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    ArrayDeque<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int l = 0; l < sz; l++) {
                            int[] poll = queue.poll();
                            grid[poll[0]][poll[1]] = '0';
                            for (int k = 0; k < 4; k++) {
                                if (poll[0] + dirt[k][0] < 0 || poll[0] + dirt[k][0] >= grid.length
                                        || poll[1] + dirt[k][1] < 0 || poll[1] + dirt[k][1] >= grid[0].length) {
                                    continue;
                                }
                                if (grid[poll[0] + dirt[k][0]][poll[1] + dirt[k][1]] == '1') {
                                    queue.add(new int[]{poll[0] + dirt[k][0], poll[1] + dirt[k][1]});
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
