package backstracking;

import java.util.LinkedList;
import java.util.List;

public class T78 {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
//        ret.add(new LinkedList<Integer>(){});
        LinkedList<Integer> integers = new LinkedList<>();
        
        backStracking(ret,integers,nums,0);
        return ret;
    }

    private void backStracking(LinkedList<List<Integer>> ret, LinkedList<Integer> integers, int[] nums, int startIndex) {

        if (startIndex > nums.length) {
            return;
        }
        ret.add(new LinkedList<>(integers));

        for (int i = startIndex; i < nums.length; i++) {
            integers.add(nums[i]);
            backStracking(ret,integers,nums,i+1);
            // 回溯
            integers.removeLast();
        }
    }

    public static void main(String[] args) {
        T78 t78 = new T78();
        List<List<Integer>> subsets = t78.subsets(new int[]{1,2});
        System.out.println(subsets);
    }
}
