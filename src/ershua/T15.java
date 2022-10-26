package ershua;

import java.util.*;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<List<Integer>> lists = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
        // 最外层控制起始
        for (int i = 0; i < nums.length; i+=map.get(nums[i])) {
            // 第二层从i+1开始
            for (int j = i+1; j < nums.length; j += map.get(nums[j])) {
                int temp = -(nums[i] + nums[j]);
                boolean a = map.containsKey(temp) && !integers.contains(nums[j]) && temp >= nums[j];
                if (a) {
                    if (temp == nums[j]) {
                        if (nums[j] == nums[i]) {
                            if (map.get(nums[j]) >= 3 ) {
                                ArrayList<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(temp);
                                integers.add(temp);
                                lists.add(list);
                            }
                        } else if (map.get(nums[j]) >= 2) {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(temp);
                            integers.add(temp);
                            lists.add(list);
                        }
                    }else {

                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(temp);
                        integers.add(temp);
                        lists.add(list);
                    }
                }
                if (nums[i] == nums[j]) {
                    j--;
                }
            }
            integers.clear();
        }
        return lists;
    }

    public static void main(String[] args) {
        T15 t15 = new T15();
        List<List<Integer>> lists = t15.threeSum(new int[]{1,-1,-1,0});
        System.out.println(111);
    }
}
