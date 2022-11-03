package ershua;

import java.util.ArrayList;
import java.util.List;

public class T77 {

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backtracking(1,n,k,ret,list);
        return ret;
    }

    private void backtracking(int i, int n, int k, ArrayList<List<Integer>> ret, ArrayList<Integer> list) {
        if (list.size() == k) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <=n ; j++) {
            list.add(j);
            backtracking(j+1,n,k,ret,list);
            // 回溯
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        T77 t77 = new T77();
        List<List<Integer>> combine = t77.combine(1, 1);
        System.out.println(111);
    }

}
