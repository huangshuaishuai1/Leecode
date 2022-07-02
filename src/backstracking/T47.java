package backstracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 先给数组排序
        Arrays.sort(nums);
        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> integers = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backStraking(nums,ret,integers,0,used);
        return ret;
    }

    private void backStraking(int[] nums,
                              LinkedList<List<Integer>> ret,
                              LinkedList<Integer> integers, int startIndex, boolean[] used) {
        if (integers.size() == nums.length) {
            ret.add(new LinkedList<>(integers));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
                continue;
            }
            if (used[i] == false) {

                used[i] = true;
                integers.add(nums[i]);
//            int count = 0;
//            for (int j = i; j < nums.length; j++) {
//                if (nums[j] == nums[i]){
//                    count++;
//                }
//            }
                backStraking(nums,ret,integers,i+1, used);
                // 回溯
                integers.removeLast();
                used[i] = false;
            }


        }
    }

    public static void main(String[] args) {
        T47 t47 = new T47();
        System.out.println(t47.permuteUnique(new int[]{1, 1, 2}));

    }

}
