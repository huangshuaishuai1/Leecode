package ershua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(ret,list,candidates,target,0);
        return ret;
    }

    private void helper(ArrayList<List<Integer>> ret, ArrayList<Integer> list, int[] candidates, int target,int sum) {
        if (sum == target) {
            ArrayList<Integer> list1 = new ArrayList<>(list);
            Collections.sort(list1);
            if (!ret.contains(list1)){
                ret.add(list1);
            }
            return;
        }
        if (sum > target)
        {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            sum += candidates[i];
            list.add(candidates[i]);
            helper(ret,list,candidates,target,sum);
            // 回溯
            list.remove(list.size()-1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        T39 t39 = new T39();
        System.out.println(t39.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(111);
    }
}
