package hot100;

public class T283 {

    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            nums[left++] = nums[i];
        }
        for (int i = nums.length - zeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
