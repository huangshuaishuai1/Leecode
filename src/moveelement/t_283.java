package moveelement;

// 快慢指针两次遍历
public class t_283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow ++;
            }
        }
        for (int i = slow; i < len; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        t_283 f = new t_283();
        int[] nums = {0, 1, 0, 3, 12};
        f.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
    }
}
