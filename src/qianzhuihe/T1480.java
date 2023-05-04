package qianzhuihe;

public class T1480 {
    public int[] runningSum(int[] nums) {
        int[] ints = new int[nums.length];
        ints[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ints[i] = ints[i-1] + nums[i];
        }
        return ints;
    }
}
