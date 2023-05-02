package ershua;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int startIndex = 0;
        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        backStracking(nums, startIndex, ret, list);
        return ret;
    }

    private void backStracking(int[] nums, int startIndex, LinkedList<List<Integer>> ret, LinkedList<Integer> list) {
        // 收集条件
        if (!ret.contains(list)) {
            ret.add(new LinkedList<>(list));
        }

        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            backStracking(nums,i+1,ret,list);
            // 回溯
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        T90 t90 = new T90();
        List<List<Integer>> lists = t90.subsetsWithDup(new int[]{
                4,4,4,1,4
        });
        System.out.println(lists);
    }
}
