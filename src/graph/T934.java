package graph;

public class T934 {
    public static void main(String[] args) {
        T934 t934 = new T934();
        int[][] ints = new int[3][3];
        ints[0] = new int[]{0,1,0};
        ints[1] = new int[]{0,0,0};
        ints[2] = new int[]{0,0,1};
//        ints[3] = new int[]{1,0,0,0,1};
//        ints[4] = new int[]{1,1,1,1,1};
        System.out.println(t934.shortestBridge(ints));
    }

    public int shortestBridge(int[][] grid) {
        // 先找到其中一个岛
        int[][] firstGrid = new int[grid.length][grid[0].length];
        int flag = 0;
        int m = 0;
        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {

                    flag = 1;
                    m = i;
                    n = j;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        findFirst(grid,m,n);

        // 开始找第二个岛
        int ans = findSecond(grid,0, -1);
        return ans - 1;
    }

    private int findSecond(int[][] grid, int i, int a) {
        i ++;
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid[0].length; k++) {
                if (grid[j][k] == a) {
                    if (j > 0) {
                        if (grid[j-1][k] == 1) {
                            return i;
                        }else if (grid[j-1][k] != a){
                            grid[j-1][k] = a-1;
                        }
                    }
                    if (k > 0) {
                        if (grid[j][k-1] == 1) {
                            return i;
                        }else if (grid[j][k-1]!= a){
                            grid[j][k-1] = a-1;
                        }
                    }

                    if (j < grid.length - 1) {
                        if (grid[j+1][k] == 1) {
                            return i;
                        }else if (grid[j+1][k]!= a){
                            grid[j+1][k] = a-1;
                        }
                    }
                    if (k < grid[0].length - 1) {
                        if (grid[j][k+1]==1) {
                            return i;
                        }else if (grid[j][k+1]!=a) {
                            grid[j][k+1] = a-1;
                        }
                    }
                }
            }
        }
        return findSecond(grid,i,a-1);
    }

    private void findFirst(int[][] grid, int m, int n) {
        grid[m][n] = -1;
        if (m > 0) {
            if (grid[m-1][n] == 1) {
                findFirst(grid,m-1,n);
            }
        }
        if (n > 0) {
            if (grid[m][n-1] == 1) {
                findFirst(grid,m,n-1);
            }
        }

        if (m < grid.length - 1) {
            if (grid[m+1][n] == 1) {
                findFirst(grid,m+1,n);
            }
        }
        if (n < grid[0].length - 1) {
            if (grid[m][n+1]==1) {
                findFirst(grid,m,n+1);
            }
        }
    }
}
