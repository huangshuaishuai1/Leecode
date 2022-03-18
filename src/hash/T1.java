package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class T1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer, Integer> hash_nums = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hash_nums.put(i , nums[i]);
        }
        Arrays.sort(nums);
        // 现在nums是从小到大排序的数组
        int a = 0;
        int b = 0;
        Set<Integer> keys = hash_nums.keySet();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            a = nums[i];
            for (int j = i+1; j < nums.length; j++){
                if (a + nums[j] == target) {
                    b = nums[j];
                    for (int key:
                            keys) {
                        if (hash_nums.get(key) == a) {
                            hash_nums.remove(key);
                            ret[0] = key;
                            break;
                        }
                    }
                    for (int key:
                            keys) {
                        if (hash_nums.get(key) == b) {
                            ret[1] = key;
                            break;
                        }
                    }

                } if (a + nums[j] > target) {
                    break;
                }
            }
        }
        return ret;
    }
}
