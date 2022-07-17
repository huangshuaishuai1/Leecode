package greedy;

import java.util.Arrays;

public class T1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            if(i < nums.length) {
                if(nums[i] <0) {
                    nums[i] = -nums[i];
                }else {
                    Arrays.sort(nums);
                    nums[0] = -nums[0];
                }
            }else{
                Arrays.sort(nums);
                nums[0] = -nums[0];
            }

        }
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
