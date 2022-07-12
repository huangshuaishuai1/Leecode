package greedy;

public class T55 {
    public boolean canJump(int[] nums) {
        int i = 0;
        int len = nums[nums.length-1] == 0? nums.length-1:nums.length;
        while (i < len) {
            while (nums[i] != 0) {
                if (i == len-1) {
                    return true;
                }
                i++;
            }
            int j;
            for (j = i-1; j>=0  ; j--) {
                if (j + nums[j] > i) {
                    i = j + nums[j];
                    break;
                }
            }
            if (j < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T55 t55 = new T55();
        System.out.println(t55.canJump(new int[]{2,2,0,2,0,2,0,0,2,0}));
    }
}
