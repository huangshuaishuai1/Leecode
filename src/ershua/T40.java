package ershua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        boolean[] used = new boolean[candidates.length];
        Arrays.fill(used,false);
        helper(candidates,target,ret,list,sum,0,used);
        return ret;
    }

    private void helper(int[] candidates, int target, ArrayList<List<Integer>> ret,
                        ArrayList<Integer> list, int sum, int startIndex,boolean[] used) {
        // 终止条件
        if (sum == target) {
            ArrayList<Integer> list1 = new ArrayList<>(list);
            if (!ret.contains(list1)){
                ret.add(list1);
            }
            return;
        }
        // 遍历宽度
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            sum += candidates[i];
            list.add(candidates[i]);
            used[i] = true;
            if (sum <= target) {
                helper(candidates,target,ret,list,sum,i+1,used);
            }else {
                sum -= candidates[i];
                list.remove(list.size()-1);
                break;
            }
            // 回溯
            sum -= candidates[i];
            list.remove(list.size()-1);
        }
    }


}
