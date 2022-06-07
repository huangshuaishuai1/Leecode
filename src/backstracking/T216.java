package backstracking;


import java.util.LinkedList;
import java.util.List;
// 找出所有相加之和为 n 的 k 个数的组合，只能用 1-9
public class T216 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1);
        return ret;
    }
    void backtracking(int k, int n, int startIndex) {
//        if (listSum(path) == n && path.size() == k) {
//            ret.add(path);
//            return;
//        }
        if (path.size() == k -1) {
            if (n - listSum(path) >= startIndex && n - listSum(path) <= 9) {
                path.add(n  - listSum(path));
                ret.add(new LinkedList<>(path));
                return;
            } else {
                path.add(0);
                return;
            }
        }

        for (int i = startIndex; i <= Math.min(n - listSum(path),9); i++) {
            path.add(i);
            backtracking(k,n,i+1);
            path.remove(path.size()-1);
            if (path.size()==k-1) {
                path.remove(path.size()-1);
            }
        }
    }
    int listSum(List<Integer> list) {
        int sum = 0;
        for (Integer item:
             list) {
            sum += item;
        }
        return sum;
    }

    public static void main(String[] args) {
        T216 t216 = new T216();
        List<List<Integer>> lists = t216.combinationSum3(2, 18);
        System.out.println(lists);
    }
}
