package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class T740 {

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
                list.add(nums[i]);
            }
        }
        int[] dp = new int[list.size()+1];
        dp[0] = 0;
        dp[1] = list.get(0) * map.get(list.get(0));
        for (int i = 2; i <= list.size(); i++) {
            Integer now = list.get(i-1);
            if (now != list.get(i-2) + 1) {
                // 如果不等于，说明直接加
                dp[i] = dp[i-1] + list.get(i-1) * map.get(list.get(i-1));
            }else {
                // 如果等于的话，就需要计算 dp[i] dp[i-1]+ list.get(i) * map.get(list.get(i)); 的最大值
                dp[i] = Math.max(dp[i-1],dp[i-2]+ list.get(i-1) * map.get(list.get(i-1)));
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        T740 t740 = new T740();
        System.out.println(t740.deleteAndEarn(new int[]{
                2, 2,  3, 3, 3, 4
        }));

    }
}

