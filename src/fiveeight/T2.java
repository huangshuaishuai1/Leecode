package fiveeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class T2 {

    public static void main(String[] args) {

    }

    public int maximumScore (int[] nums, int k) {
        // write code here
        int ans = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            for (int j = tmp - k; j <= tmp + k ; j++) {
                Integer orDefault = map.getOrDefault(j,0);
                orDefault++;
                ans = Math.max(ans,orDefault);
                map.put(j,orDefault);
            }
        }

        return ans;
    }
}
