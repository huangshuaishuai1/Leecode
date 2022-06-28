package backstracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> integers = new LinkedList<>();
        // 要先给nums 排个序
        Arrays.sort(nums);
        backStracking(ret,integers,nums,0);
        return ret;
    }

    private void backStracking(LinkedList<List<Integer>> ret, LinkedList<Integer> integers, int[] nums, int startIndex) {
        if (startIndex > nums.length) {
            return;
        }

        ret.add(new LinkedList<>(integers));


        for (int i = startIndex; i < nums.length; i++) {
            // 剪枝
            if (i > startIndex && nums[i] == nums[i-1]  ) {
                continue;
            }
            integers.add(nums[i]);
            backStracking(ret,integers,nums,i+1);
            integers.removeLast();
        }
    }

    public static void main(String[] args) {
        T90 t90 = new T90();
        List<List<Integer>> lists = t90.subsetsWithDup(new int[]{1,2,2});
        System.out.println(lists);
    }
}
