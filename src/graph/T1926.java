package graph;

public class T1926 {

    public static void main(String[] args) {
        T1926 t1926 = new T1926();
        char[][] chars = new char[1][2];
        chars[0] = new char[]{'.','+'};
//        chars[1] = new char[]{'.','.','.'};
//        chars[2] = new char[]{'+','+','+'};

        System.out.println(t1926.nearestExit(chars, new int[]{0, 0}));
    }

    static int ans = -1;
    static int f = 0;
    public int nearestExit(char[][] maze, int[] entrance) {
        if (maze.length == 1 && maze[0].length == 1) {
            return 0;
        }
        int[][] used = new int[maze.length][maze[0].length];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == '+') {
                    used[i][j] = 1;
                }
            }
        }
        dfs(used, entrance);

        if(f == 0) {
            return -1;
        }
        return ans;
    }

    private static void dfs(int[][] used, int[] entrance) {
        used[entrance[0]][entrance[1]] = 1;
        ans++;

        if (ans != 0) {
            if (entrance[0] == 0 || entrance[0] == used.length - 1 || entrance[1] == 0 || entrance[1] == used[0].length) {
                f = 1;
                return;
            }
        }

        if (entrance[0] - 1 >= 0) {
            if (used[entrance[0] - 1][entrance[1]] != 1) {
                dfs(used, new int[]{entrance[0] - 1, entrance[1]});
                if (f == 1) {
                    return;
                }
                used[entrance[0] - 1][entrance[1]] = 0;
            }
        }

        if (entrance[0] + 1 <= used.length-1) {
            if (used[entrance[0] + 1][entrance[1]] != 1) {
                dfs(used, new int[]{entrance[0] + 1, entrance[1]});
                if (f == 1) {
                    return;
                }
                used[entrance[0] + 1][entrance[1]] = 0;
            }
        }
        if (entrance[1] - 1 >= 0) {
            if (used[entrance[0] ][entrance[1] - 1] != 1) {
                dfs(used, new int[]{entrance[0], entrance[1]-1});
                if (f == 1) {
                    return;
                }
                used[entrance[0]][entrance[1]-1] = 0;
            }
        }

        if (entrance[1] + 1 <= used[0].length-1) {
            if (used[entrance[0]][entrance[1]+1] != 1) {
                dfs(used, new int[]{entrance[0], entrance[1] + 1});
                if (f == 1) {
                    return;
                }
                used[entrance[0]][entrance[1] + 1] = 0;
            }
        }

    }
}
