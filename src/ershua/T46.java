package ershua;

import java.util.LinkedList;
import java.util.List;

public class T46 {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int[] used = new int[nums.length];
        backStracking(ret, list, used, nums);
        return ret;
    }

    private void backStracking(LinkedList<List<Integer>> ret, LinkedList<Integer> list, int[] used, int[] nums) {
        if (list.size() == nums.length) {
            ret.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                list.add(nums[i]);
                used[i] = 1;
                backStracking(ret, list, used, nums);
                used[i] = 0;
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        T46 t46 = new T46();
        List<List<Integer>> permute = t46.permute(new int[]{1});
        System.out.println(permute);
    }
}
