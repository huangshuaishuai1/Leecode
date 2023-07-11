package graph;

import ershua.T46;

import java.util.ArrayDeque;

public class T463 {
    public static void main(String[] args) {
        T463 t463 = new T463();
        int[][] grid = {{1,0}};
        System.out.println(t463.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] dirt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = 0;
        int[][] used = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    used[i][j] = 1;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] poll = queue.poll();
                            int tmp = 4;
                            for (int l = 0; l < 4; l++) {
                                if (poll[0] + dirt[l][0] < 0 || poll[0] + dirt[l][0] >= grid.length
                                        || poll[1] + dirt[l][1] < 0 || poll[1] + dirt[l][1] >= grid[0].length) {
                                    continue;
                                }
                                if (grid[poll[0] + dirt[l][0]][poll[1] + dirt[l][1]] == 1) {
                                    if (used[poll[0] + dirt[l][0]][poll[1] + dirt[l][1]] == 0) {
                                        queue.add(new int[]{poll[0] + dirt[l][0], poll[1] + dirt[l][1]});
                                        used[poll[0] + dirt[l][0]][poll[1] + dirt[l][1]] = 1;
                                    }
                                    tmp--;
                                }
                            }
                            ans += tmp;
                        }
                    }
                    return ans;
                }
            }
        }
        return ans;
    }
}
