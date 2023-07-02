package graph;

import java.util.ArrayDeque;

public class T1926 {

    public static void main(String[] args) {
        T1926 t1926 = new T1926();
        char[][] chars = new char[1][2];
        chars[0] = new char[]{'+','.'};
//        chars[1] = new char[]{'.','.','.'};
//        chars[2] = new char[]{'+','+','+'};

        System.out.println(t1926.nearestExit(chars, new int[]{0, 1}));
    }


    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirt = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{entrance[0],entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int ans = 0;
        while (!queue.isEmpty()) {
            ans ++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                // 遍历每一个可以到的格子
                int[] poll = queue.poll();
                maze[poll[0]][poll[1]] = '+';
                for (int j = 0; j < 4; j++) {
                    if (poll[0] + dirt[j][0] < 0 || poll[0] + dirt[j][0] > maze.length-1
                    || poll[1] + dirt[j][1] < 0 || poll[1] + dirt[j][1] > maze[0].length-1) {
                        continue;
                    }
                    if (maze[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] == '.') {
                        if (poll[0] + dirt[j][0] == 0 || poll[0] + dirt[j][0] == maze.length-1
                        || poll[1] + dirt[j][1] == 0 || poll[1] + dirt[j][1] == maze[0].length-1) {
                            return ans;
                        }
                        queue.add(new int[]{poll[0] + dirt[j][0],poll[1] + dirt[j][1]});
                        maze[poll[0] + dirt[j][0]][poll[1] + dirt[j][1]] = '+';
                    }
                }
            }
        }

        return -1;
    }


}
