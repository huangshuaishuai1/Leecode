package douyin;

import java.util.ArrayDeque;

public class T {

    public static void main(String[] args) {
        T t = new T();
        int[][] arr = new int[][]{{2,2,2,2,2,2,2},{2,0,0,0,0,0,2},{2,0,2,0,2,0,2},{2,0,0,2,0,2,2},{2,2,0,2,0,2,2},{2,0,0,0,0,0,0,2},{2,2,2,2,2,2,0,2}};
        int[] start = new int[]{1,1};
        System.out.println(t.nearestExit(arr, start));
    }

    public int nearestExit(int[][] maze, int[] entrance) {
        // 不是用DP，是图的遍历的题目
        int[][] dirt = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // 初始点
        queue.add(new int[]{entrance[0],entrance[1]});
        // 遍历过的地方要变为 墙
        maze[entrance[0]][entrance[1]] = 2;
        int ans = 0;
        while (!queue.isEmpty()) {

            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                // 遍历每一个可以到的格子
                int[] poll = queue.poll();
                maze[poll[0]][poll[1]] = 2;
                for (int j = 0; j < 4; j++) {
                    if (poll[0] + dirt[j][0] < 0 || poll[0] + dirt[j][0] > maze.length-1
                            || poll[1] + dirt[j][1] < 0 || poll[1] + dirt[j][1] > maze[0].length-1) {
                        continue;
                    }
                    if (maze[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] == 0) {
                        if (poll[0] + dirt[j][0] == 0 || poll[0] + dirt[j][0] == maze.length-1
                                || poll[1] + dirt[j][1] == 0 || poll[1] + dirt[j][1] == maze[0].length-1) {
                            ans++;
                        }
                        queue.add(new int[]{poll[0] + dirt[j][0],poll[1] + dirt[j][1]});
                        maze[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] = 2;
                    }
                }
            }
        }

        return ans;
    }

}
