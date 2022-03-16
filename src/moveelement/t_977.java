package moveelement;

public class t_977 {

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] n = new int[nums.length];
        int len = nums.length-1;
        while (len >= 0) {
            if (nums[left]*nums[left] >= nums[right]*nums[right]) {
                n[len--] = nums[left] * nums[left];
                left++;
            } else {
                n[len--] = nums[right] * nums[right];
                right--;
            }
        }
        return n;

    }
    public static void main(String[] args) {
        t_977 t_977 = new t_977();
        int[] nums = {-4, -1, 0, 3, 10};
        int[] ints = t_977.sortedSquares(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
//        System.out.println(ints);

    }
}
