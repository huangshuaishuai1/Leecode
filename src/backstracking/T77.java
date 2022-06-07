package backstracking;

import java.util.LinkedList;
import java.util.List;

public class T77 {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();
        backStracking(n,k,1,path,ret);
        return ret;
    }
    void backStracking(int n, int k, int starIndex, List<Integer> path, List<List<Integer>> ret) {
        if (path.size() == k) {
            ret.add(new LinkedList<Integer>(path));
            return;
        }
        for (int i = starIndex; i <= n; i++) {
            path.add(i);
            backStracking(n,k,i+1,path,ret);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        T77 t77 = new T77();
        List<List<Integer>> combine = t77.combine(1, 1);
        System.out.println(combine);
    }
}
