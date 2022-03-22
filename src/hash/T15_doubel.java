package hash;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;


public class T15_doubel {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 3) {
            return ret;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                }else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                }else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[l]);
                    integers.add(nums[r]);
                    Collections.sort(integers);
                    if (!ret.contains(integers)) {
                        ret.add(integers);
                    }
                    r--;
                    l++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T15_doubel t15 = new T15_doubel();
        int[] nums = new int[] {-2,0,1,1,2};
        List<List<Integer>> lists = t15.threeSum(nums);
        System.out.println(lists);
    }

}
