package hash;

import java.util.*;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
//        if (nums.length < 3) {
//            return null;
//        }
        HashMap<Integer, Integer> numsFrequency = new HashMap<>();
//      得到所有num的词频
        for (int number :
                nums) {
            if (numsFrequency.containsKey(number)) {
                numsFrequency.put(number, numsFrequency.get(number) + 1);
            } else {
                numsFrequency.put(number, 1);
            }
        }

        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int rest = -nums[i] - nums[j];
                if (numsFrequency.containsKey(rest)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    if (nums[i] == rest && nums[j] == rest) {
                        if (numsFrequency.get(rest) > 2) {
                            triplet.add(rest);
                            Collections.sort(triplet);
                            if (! triplets.contains(triplet)){
                                triplets.add(triplet);
                            }

                        }
                    } else if (nums[i] == rest || nums[j] == rest) {
                        if (numsFrequency.get(rest) > 1) {
                            triplet.add(rest);
                            Collections.sort(triplet);
                            if (! triplets.contains(triplet)){
                                triplets.add(triplet);
                            }
                        }
                    } else {
                        triplet.add(rest);
                        Collections.sort(triplet);
                        if (! triplets.contains(triplet)){
                            triplets.add(triplet);
                        }
                    }
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        T15 t15 = new T15();
        int[] nums = new int[] {-1,0,1,0};
        List<List<Integer>> lists = t15.threeSum(nums);
        System.out.println(lists);
    }

}
