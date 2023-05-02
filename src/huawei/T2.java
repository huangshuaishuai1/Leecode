package huawei;

import java.util.ArrayList;
import java.util.Stack;

public class T2 {
    static int d[] = new int[500010];
    static ArrayList<Integer>g[] = new ArrayList[500010];
    static int st[] = new int[500010];
    static Stack<Integer> ans = new Stack<>();
    static boolean dfs (int u, int fa) {
        if (st[u] == 1) return false;
        ans.add(u);
        if (d[u] == 1) {
            return true;
        }
        boolean f = false;
        for (Integer j : g[u]) {
            if (j == fa) continue;
            if (f == true) return true;
            f |= dfs(j,u);
        }
        ans.pop();
        return f;
    }
    public static void main(String[] args) {

    }
}
