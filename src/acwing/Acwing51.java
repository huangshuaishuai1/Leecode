package acwing;

import java.util.ArrayList;
import java.util.List;

public class Acwing51 {


    public List<List<Integer>> permutation(int[] nums) {
        int[] used = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> ret = new ArrayList<>();
        helper(nums, used, list, ret);
        return ret;
    }

    private void helper(int[] nums, int[] used, ArrayList<Integer> list, ArrayList<List<Integer>> ret) {
        if (list.size() == nums.length) {
            ArrayList<Integer> tmp = new ArrayList<>(list);
            if (!ret.contains(tmp)){
                ret.add(tmp);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] != 1) {
                list.add(nums[i]);
                used[i] = 1;
                helper(nums,used,list, ret);
                // 回溯
                used[i] = 0;
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Acwing51 acwing51 = new Acwing51();
        List<List<Integer>> permutation = acwing51.permutation(new int[]{1, 2,2, 3});
        System.out.println(111);
    }
}
