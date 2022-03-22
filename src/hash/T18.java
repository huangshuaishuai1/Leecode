package hash;

import java.util.*;

public class T18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 4) {
            return ret;
        }
        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = nums.length-1; j > i + 2; j--) {
                int l = i + 1;
                int r = j - 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] + nums[j] < target) {
                        l++;
                    }else if (nums[i] + nums[l] + nums[r] + nums[j] > target) {
                        r--;
                    }else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[r]);
                        list.add(nums[l]);
                        Collections.sort(list);
                        if (!ret.contains(list)) {
                            ret.add(list);
                        }
                        l++;
                        r--;

                    }
                }
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        T18 t18 = new T18();
        List<List<Integer>> lists = t18.fourSum(new int[] {0,0,0,0},0);
        System.out.println(lists);
    }
}
