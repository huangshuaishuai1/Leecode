package unionfindset;

public class T1971 {

    static int[] father = new int[200001];

    public static int find(int x) {
        while (x != father[x]) {
            x = father[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int fatherX = find(x);
        int fatherY = find(y);
        if (fatherX < fatherY) {
            father[fatherY] = fatherX;
        }else {
            father[fatherX] = fatherY;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 初始化
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        // 合并
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            union(a,b);
        }
        int P1 = find(source);
        int P2 = find(destination);
        return P1 == P2;
    }
}
