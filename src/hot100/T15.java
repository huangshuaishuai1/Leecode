package hot100;

import java.util.*;

public class T15 {
    public static void main(String[] args) {
        T15 t15 = new T15();
        List<List<Integer>> lists = t15.threeSum(new int[]{3,0,-2,-1,1,2});
        System.out.println(111);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = nums[i];
            for(int j = nums.length-1; j > i; j--) {
                if(j < nums.length-1 && nums[j] == nums[j+1]) {
                    continue;
                }
                int r = nums[j];
                int gap = 0-l-r;
                if(gap > r || gap < l) {
                    continue;
                }
                if(map.containsKey(gap)) {
                    // gap和l r 不相等
                    if(gap != l && gap != r) {
                        List<Integer> list = Arrays.asList(l,r,gap);
                        ans.add(list);
                    }
                    // gap和l r 中的一个相等
                    else if(l == r) {
                        // 看看gap
                        if(gap == l && map.get(gap) > 2) {
                            List<Integer> list = Arrays.asList(l,r,gap);
                            ans.add(list);
                        } else if(gap != l){
                            List<Integer> list = Arrays.asList(l,r,gap);
                            ans.add(list);
                        }
                    } else if((gap == l || gap == r) && map.get(gap) > 1) {
                        List<Integer> list = Arrays.asList(l,r,gap);
                        ans.add(list);
                    }
                }
            }

        }
        return ans;
    }
}
