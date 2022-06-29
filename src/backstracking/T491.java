package backstracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> integers = new LinkedList<>();

        backStracking(ret,integers,nums,0);
        return ret;
    }

    private void backStracking(LinkedList<List<Integer>> ret, LinkedList<Integer> integers, int[] nums, int startIndex) {
        // 终止条件
        if (integers.size() >=2 ){
            LinkedList<Integer> item = new LinkedList<>(integers);
//            if (!ret.contains(item)){  //这一行耗时好多
                ret.add(item);
//            }

            if (startIndex > nums.length) {
                return;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {

            if (!integers.isEmpty() && nums[i] < integers.getLast()) {
                continue;
            }

            // 使用了该数字
            if (map.getOrDefault(nums[i],0) >= 1) {
                continue;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            integers.add(nums[i]);
            backStracking(ret,integers,nums,i+1);
            // 回溯
            integers.removeLast();
            // 把所有相等的跳过去


        }
    }

    public static void main(String[] args) {
        T491 t491 = new T491();
        List<List<Integer>> subsequences = t491.findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1});
        System.out.println(subsequences);
    }
}
