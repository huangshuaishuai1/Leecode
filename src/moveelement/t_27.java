package moveelement;

//暴力法
public class t_27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i;j < len - 1;j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                len--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        t_27 f = new t_27();
        int[] nums = {0,1,2,2,3,0,4,2};
        int result = f.removeElement(nums,2);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i]);
        }
    }
}
