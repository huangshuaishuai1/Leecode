package backstracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T216_2 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1);
        return ret;
    }
    void backtracking(int k, int n, int startIndex) {

        if (listSum(path) > n) {
            return;
        }
        if (path.size() == k) {
            if (listSum(path) == n) {
                ret.add(new ArrayList<>(path));
                return;
            }
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(k,n,i+1);
            path.removeLast();
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
        T216_2 t216 = new T216_2();
        List<List<Integer>> lists = t216.combinationSum3(3, 9);
        System.out.println(lists);
    }
}
