package backstracking;

import java.util.LinkedList;
import java.util.List;

// 可以剪枝，要先对candidates进行排序
public class T39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        int sum = 0;
        LinkedList<Integer> integers = new LinkedList<>();
        backStracking(0,sum,target,candidates,ret,integers);
        return ret;
    }

    public void backStracking(int starIndex, int sum, int target, int[] candidates, LinkedList<List<Integer>> ret, LinkedList<Integer> integers) {
        if (sum >= target) {
            if (sum==target) {
                ret.add(new LinkedList<>(integers));
            }
            return;
        }
        for (int i = starIndex; i < candidates.length; i++) {
            sum += candidates[i];
            integers.add(candidates[i]);
            if (sum <= target) {
                backStracking(i,sum,target,candidates,ret,integers);
            }
            // 回溯
            Integer remove = integers.remove(integers.size()-1);
            sum-=remove;
        }
    }

    public static void main(String[] args) {
        T39 t39 = new T39();
        int[] ints = {2, 3, 6, 7};
        int target = 1;
        List<List<Integer>> lists = t39.combinationSum(ints, target);
        System.out.println(lists);
    }
}
