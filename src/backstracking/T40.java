package backstracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        if (candidates.length==0) {
            return ret;
        }
        int sum = 0;
        LinkedList<Integer> sumList = new LinkedList<>();
        Arrays.sort(candidates);
        backStracking(0,sum,candidates,target,ret,sumList);
        return ret;
    }
    public void backStracking(int index, int sum, int[] candidates, int target, LinkedList<List<Integer>> ret, LinkedList<Integer> sumList){
        if (sum >= target) {
            if (sum == target && !ret.contains(new LinkedList<>(sumList))) {
                ret.add(new LinkedList<>(sumList));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if ( i > index && candidates[i] == candidates[i - 1] ) {
                continue;
            }
            sum += candidates[i];
            sumList.add(candidates[i]);
            if (sum > target) {
                Integer integer = sumList.removeLast();
                sum-=integer;
                break;
            }
            backStracking(i+1,sum,candidates,target,ret,sumList);
            // 回溯
            Integer integer = sumList.removeLast();
            sum-=integer;


        }

    }

    public static void main(String[] args) {
        T40 t40 = new T40();
        List<List<Integer>> lists = t40.combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30);
        System.out.println(lists);
    }
}
