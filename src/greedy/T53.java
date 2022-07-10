package greedy;

public class T53 {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {

            if (sum + nums[i] < nums[i]) {
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }

    public static void main(String[] args) {
        T53 t53 = new T53();
        System.out.println(t53.maxSubArray(new int[]{-2, -1}));
        System.out.println("---");
    }
}
