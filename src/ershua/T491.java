package ershua;

import java.util.*;

public class T491 {


    public List<List<Integer>> findSubsequences(int[] nums) {
        int startIndex = 0;
        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();

        backStracking(nums, startIndex, ret, numList);
        return ret;
    }

    private void backStracking(int[] nums, int startIndex, LinkedList<List<Integer>> ret, LinkedList<Integer> numList) {
        // 收集条件
        if (numList.size() >= 2) {
            ret.add(new LinkedList<>(numList));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!numList.isEmpty() && nums[i] < numList.getLast() || set.contains(nums[i]) ) {
                continue;
            }
            numList.add(nums[i]);
            set.add(nums[i]);
            backStracking(nums,i+1,ret,numList);
            numList.removeLast();
        }
    }

    public static void main(String[] args) {
        T491 t491 = new T491();
        List<List<Integer>> subsequences = t491.findSubsequences(new int[]{4, 6,7,7});
        System.out.println(subsequences);
    }
}
