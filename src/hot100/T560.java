package hot100;

import java.util.Arrays;
import java.util.HashMap;

public class T560 {

    public static void main(String[] args) {
        T560 t560 = new T560();
        System.out.println(t560.subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            ans+=map.getOrDefault(pre-k,0);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return ans;
    }
}
