package graph;

import java.util.ArrayDeque;
import java.util.Arrays;

public class T542 {
    public static void main(String[] args) {
        T542 t542 = new T542();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints = t542.updateMatrix(mat);
        System.out.println(111);
    }

    private int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        int[][] used = new int[mat.length][mat[0].length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    used[i][j] = 1;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] poll = queue.poll();
                for (int l = 0; l < 4; l++) {
                    if (poll[0] + direct[l][0] < 0 || poll[0] + direct[l][0] >= mat.length || poll[1] + direct[l][1] < 0 || poll[1] + direct[l][1] >= mat[0].length) {
                        continue;
                    }
                    if (mat[poll[0] + direct[l][0]][poll[1] + direct[l][1]] == 1 && used[poll[0] + direct[l][0]][poll[1] + direct[l][1]] == 0) {
                        ans[poll[0] + direct[l][0]][poll[1] + direct[l][1]] = step;
                        queue.add(new int[]{poll[0] + direct[l][0], poll[1] + direct[l][1]});
                        used[poll[0] + direct[l][0]][poll[1] + direct[l][1]] = 1;
                    }
                }

            }
        }
        return ans;
    }

}
