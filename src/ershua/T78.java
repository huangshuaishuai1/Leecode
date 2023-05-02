package ershua;

import java.util.ArrayList;
import java.util.List;

public class T78 {

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        int startIndex = 0;
        backStracking(nums,startIndex,numList,ret);
        return ret;
    }

    private void backStracking(int[] nums, int startIndex, ArrayList<Integer> numList, ArrayList<List<Integer>> ret) {
        // 收集条件
        if (!ret.contains(numList)) {
            ret.add(new ArrayList<>(numList));
        }

        for (int i = startIndex; i < nums.length; i++) {
            numList.add(nums[i]);
            backStracking(nums,i+1,numList,ret);
            // 回溯
            numList.remove(numList.size()-1);
        }

    }

    public static void main(String[] args) {
        T78 t78 = new T78();
        List<List<Integer>> subsets = t78.subsets(new int[]{
                1, 2, 3
        });
        System.out.println(subsets);
    }
}
