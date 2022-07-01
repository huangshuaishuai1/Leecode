package backstracking;

import java.util.*;

public class T46 {
    public List<List<Integer>> permute(int[] nums) {
        // 全排列
        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> integers = new LinkedList<>();
//        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        backStracking(queue,nums,ret,integers, 0);
        return ret;
    }

    private void backStracking(Queue<Integer> used,int[] nums, LinkedList<List<Integer>> ret, LinkedList<Integer> integers,int startIndex) {
        // 终止条件
        if (startIndex == nums.length) {
            ret.add(new LinkedList<>(integers));
            return;
        }

        // 循环遍历添加
        for (int i = startIndex; i < nums.length; i++) {
            integers.add(used.poll());
            backStracking(used,nums,ret,integers,integers.size());
            used.add(integers.removeLast());
        }
    }


    public static void main(String[] args) {
        T46 t46 = new T46();
        System.out.println(t46.permute(new int[]{1,2,3}));
    }
}
