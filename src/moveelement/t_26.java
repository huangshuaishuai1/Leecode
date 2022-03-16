package moveelement;

public class t_26 {

    // 快慢指针

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int slow = 0;
        for (int fast = 0; fast<len; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[slow + 1] = nums[fast];
                slow ++;
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        t_26 f = new t_26();
        int[] nums = {0, 0, 1, 1, 2, 3, 4};
        int results = f.removeDuplicates(nums);
        System.out.println(results);
        for (int i = 0; i < results; i++) {
            System.out.print(nums[i]);
        }
    }
}
