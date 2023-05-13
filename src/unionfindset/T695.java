package unionfindset;

public class T695 {
    static int[] parent = null;
    static int[] num = null;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    static int union(int x, int y) {
        int parentX =  find(x);
        int parentY = find(y);
        parent[parentY] = parentX;
        num[parentX]+=num[parentY];
        return num[parentX];
    }

    public int maxAreaOfIsland(int[][] grid) {
        // 初始化
        int tag = 0;
        parent = new int[grid.length * grid[0].length];
        num = new int[grid.length * grid[0].length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            if (grid[(i)/grid[0].length ][i % grid[0].length] == 1) {
                num[i] = 1;
                tag=1;
            }
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j != 0 && grid[i][j] == 1 && grid[i][j-1] == 1 && find(i * grid[0].length + j -1) != find(i * grid[0].length + j)) {
                    int union = union(i * grid[0].length + j -1 , i * grid[0].length + j );
                    ans = Math.max(union,ans);
                }
                if (i != 0 && grid[i-1][j] == 1 && grid[i][j] == 1 && find((i - 1) * grid[0].length + j) != find(i * grid[0].length + j)) {
                    int union = union((i - 1) * grid[0].length + j, i * grid[0].length + j);
                    ans = Math.max(union,ans);
                }
            }
        }
        return Math.max(tag,ans);
    }

    public static void main(String[] args) {
        T695 t695 = new T695();
        int[][] ints = new int[8][13];
        ints[0] = new int[] {0,0,1,0,0,0,0,1,0,0,0,0,0};
        ints[1] = new int[] {0,0,0,0,0,0,0,1,1,1,0,0,0};
        ints[2] = new int[] {0,1,1,0,1,0,0,0,0,0,0,0,0};
        ints[3] = new int[] {0,1,0,0,1,1,0,0,1,0,1,0,0};
        ints[4] = new int[] {0,1,0,0,1,1,0,0,1,1,1,0,0};
        ints[5] = new int[] {0,0,0,0,0,0,0,0,0,0,1,0,0};
        ints[6] = new int[] {0,0,0,0,0,0,0,1,1,1,0,0,0};
        ints[7] = new int[] {0,0,0,0,0,0,0,1,1,0,0,0,0};

        System.out.println(t695.maxAreaOfIsland(ints));
    }
}
