package ershua;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();

        int[] used = new int[nums.length];
        Arrays.sort(nums);
        backStacking(ret,list,used,nums);
        return ret;
    }

    void backStacking(LinkedList<List<Integer>> ret, LinkedList<Integer> list, int[] used, int[] nums) {
        if (list.size() == nums.length) {
            ret.add(new LinkedList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && used[i-1] == 0  && nums[i] == nums[i-1]) {
                continue;
            }
            if (used[i] == 0) {

                used[i] = 1;
                list.add(nums[i]);
                backStacking(ret,list,used,nums);
                used[i] = 0;
                list.removeLast();
            }

        }
    }

    public static void main(String[] args) {
        T47 t47 = new T47();
        List<List<Integer>> lists = t47.permuteUnique(new int[]{1, 1, 2});

        System.out.println("lists = " + lists);


    }
}
