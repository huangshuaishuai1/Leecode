package KDXF;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class MHYT1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int m = scanner.nextInt();
        int[][] position = new int[3][2];
        for (int i = 0; i < 3; i++) {
            position[i][0] = scanner.nextInt()-1;
            position[i][1] = scanner.nextInt()-1;
        }

        // 米小游【0】先找月下【1】，再找奥托【2】
        int step1 = bfs(n,m,position[0],position[1]);
        System.gc();
        int step2 = bfs(n,m,position[1],position[2]);
        System.out.println(step1+step2);
    }

    public static int bfs(int n, int m, int[] start, int[] end) {
        // 上下左右
        int[][] next = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int ans = 0;
        int x = start[0];
        int y = start[1];
        int[][] used = new int[n][m];
        used[x][y] = 1;
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(new int[]{x,y});
        while (!arrayDeque.isEmpty()) {
            int size= arrayDeque.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] poll = arrayDeque.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = 0;
                    int nextY = 0;
                    if (poll[0]+next[j][0] == -1) {
                        nextX = n-1;
                    } else if (poll[0]+next[j][0] == n) {
                        nextX = 0;
                    }else {
                        nextX = poll[0]+next[j][0];
                    }
                    if (poll[1]+next[j][1] == -1) {
                        nextY = m-1;
                    } else if (poll[1]+next[j][1] == m) {
                        nextY = 0;
                    }else {
                        nextY = poll[1]+next[j][1];
                    }

                    if (nextX == end[0] && nextY == end[1]) {
                        return ans;
                    }
                    if (used[nextX][nextY] == 0) {
                        used[nextX][nextY] =1;
                        arrayDeque.add(new int[]{nextX,nextY});
                    }
                }
            }
        }
        return ans;
    }
}
