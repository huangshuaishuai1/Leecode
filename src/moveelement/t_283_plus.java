package moveelement;

// 快慢指针一次遍历
public class t_283_plus {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow ++;
            }
        }
    }

    public static void main(String[] args) {
        t_283_plus f = new t_283_plus();
        int[] nums = {1};
        f.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
    }
}
