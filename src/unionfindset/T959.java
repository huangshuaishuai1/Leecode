package unionfindset;

public class T959 {
    // 将每个格子看作是上下左右四个小三角形
    static int[] parent = new int[3601];

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public static void union(int x,int y) {
        parent[find(y)] = parent[find(x)];
    }

    public int regionsBySlashes(String[] grid) {
        // 初始化
        int len = grid.length;
        for (int i = 0; i < len * len * 4; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < len; i++) {
            String str = grid[i];
            // 遍历每个格子

            for (int j = 0; j < len; j++) {
                char tmp = str.charAt(j);
                int one = i*len*4 + j*4;
                if (tmp == '\\') {
                    union(one, one+3);
                    union(one+1,one+2);

                }else if (tmp=='/'){
                    union(one,one+2);
                    union(one+1,one+3);
                }else {
                    union(one,one+1);
                    union(one,one+2);
                    union(one,one+3);
                }
                if (i != 0) {
                    int lastRow = i-1;
                    int lastTwo = lastRow*len*4+j*4+1;
                    union(lastTwo,one);
                }
                if (j != 0) {
                    union(one-1,one+2);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < len * len * 4; i++) {
            if (parent[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        T959 t959 = new T959();
        System.out.println(t959.regionsBySlashes(new String[]{"/\\", "\\/"}));
    }

}
