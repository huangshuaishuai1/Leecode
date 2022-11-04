package ershua;

import java.util.ArrayList;
import java.util.List;

public class T216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(ret,list,k,n,0,1);
        return ret;
    }

    private void helper(ArrayList<List<Integer>> ret, ArrayList<Integer> list,
                        int k, int n, int sum,int starIndex) {
        // 终止条件
        if (list.size() == k) {
            if (sum == n) {
                ret.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = starIndex; i <= Math.min(n - sum,9); i++) {
            // 操作这个i
            sum += i;
            list.add(i);
            helper(ret,list,k,n,sum,i+1);
            // 回溯
            list.remove(list.size()-1);
            sum -= i;
        }
    }

    public static void main(String[] args) {
        T216 t216 = new T216();
        List<List<Integer>> lists = t216.combinationSum3(2, 18);
        System.out.println(111);
    }

}
