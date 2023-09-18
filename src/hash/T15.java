package hash;

import java.util.*;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<>();
        if(nums[0] > 0 || nums[nums.length-1] < 0) {
            return list;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i],0);
            count ++;
            map.put(nums[i],count);
        }

        int l = 0;
        int r = nums.length-1;

        while(l < r) {
            int gap = 0-nums[l] - nums[r];
            if(gap == nums[l] || gap == nums[r]) {
                if(gap == 0 && map.get(0) >=3) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(0);
                    tmp.add(0);
                    tmp.add(0);
                    list.add(tmp);
                } else {
                    if(map.get(gap) >= 2) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);
                        tmp.add(gap);
                        list.add(tmp);
                    }
                }
            } else {
                if(map.containsKey(gap)) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    tmp.add(gap);
                    list.add(tmp);
                }
            }
            if(gap > 0) {
                l += map.get(nums[l]);
            }else if(gap < 0) {
                r -= map.get(nums[r]);
            }else {
                r -= map.get(nums[r]);
                l += map.get(nums[l]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        T15 t15 = new T15();
        int[] nums = new int[] {-1,0,1,0};
        List<List<Integer>> lists = t15.threeSum(nums);
        System.out.println(lists);
    }

}
