package moveelement;

// 快慢指针
public class t_27_plus {
    public int removeElement(int[] nums, int val) {
       int slow  = 0;
        for (int fast = 0; fast < nums.length - 1; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }

        }
        return slow;
    }

    public static void main(String[] args) {
        t_27_plus f = new t_27_plus();
        int[] nums = {3, 2, 2, 3};
        int result = f.removeElement(nums, 3);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i]);
        }

    }
}
