package hot100;

import java.util.HashMap;

public class T1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        int[] ints = t1.twoSum(new int[]{3,3}, 6);
        System.out.println(111);
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
        }
        return null;
    }
}
