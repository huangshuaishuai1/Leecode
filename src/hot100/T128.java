package hot100;

import java.util.Arrays;

public class T128 {

    public static void main(String[] args) {
        T128 t128 = new T128();
        System.out.println(t128.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int ans = 1;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                ans = Math.max(i-left+1-count,ans);
            }else if (nums[i] == nums[i-1]){
                count++;
                continue;
            } else {
                count=0;
                left = i;
            }
        }
        return ans;
    }
}
