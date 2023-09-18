package nenglian;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class T2 {

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.exist(new String[]{"XYZE", "SFZS", "XDEE"}, "XYZZED"));
    }

    public boolean exist (String[] board, String word) {
        // write code here

        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < board[0].length(); j++) {
                if (s.charAt(0) != word.charAt(0)) {
                }else {
                    if (func(i,j,board,word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean func(int m, int n, String[] board, String word) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] used = new int[board.length][board[0].length()];
        used[m][n] = 1;
        int count = 1;
        int[][] dirt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.add(new int[]{m,n});
        while (queue.size()!=0) {
            int[] poll = queue.poll();
            int tag = 0;
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dirt[i][0];
                int y = poll[1] + dirt[i][1];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length() || board[x].charAt(y) != word.charAt(count) || used[x][y] == 1 ) {
                    continue;
                }
                queue.add(new int[]{x,y});
                used[x][y] = 1;
                tag = 1;
            }
            if (tag == 1) {
                count ++;
                if (count == word.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
