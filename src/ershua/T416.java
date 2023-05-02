package ershua;

public class T416 {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if(total % 2 != 0) {
            return false;
        }
        return backStracking(nums,0,total/2,0);
    }

    boolean backStracking(int[] nums, int sum, int target,int startIndex) {
        if(sum == target) {
            return true;
        }
        for(int i = startIndex; i < nums.length; i++) {
            if(nums[i] + sum <= target) {
                boolean ret = backStracking(nums,sum+nums[i],target,i+1);
                if(ret) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T416 t416 = new T416();
        boolean b = t416.canPartition(new int[]{1, 2, 5});
        System.out.println(b);
    }
}
