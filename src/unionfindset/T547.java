package unionfindset;

public class T547 {

    public static void main(String[] args) {

        T547 t547 = new T547();
        int[][] isConnected = new int[3][3];
        isConnected[0] = new int[]{1,1,0};
        isConnected[1] = new int[]{1,1,0};
        isConnected[2] = new int[]{0,0,1};
        int circleNum = t547.findCircleNum(isConnected);
        System.out.println(circleNum
        );
    }
    
    //  并查集
    static int [] parent;

    public int findParent(int index) {
        if (parent[index] == index) {
            return index;
        }else {
            parent[index] =  findParent(parent[index]);
            return parent[index];
        }
    }

    
    // 合并
    public void union(int index1, int index2) {
        int firstParent = findParent(index1);
        int secondParent = findParent(index2);
        
        parent[secondParent] = parent[firstParent];
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        // 初始化
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int low = Math.min(i,j);
                    int high = Math.max(i,j);
                    union(low,high);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (findParent(i) == i) {
                ans++;
            }
        }
        return ans;
    }
}
