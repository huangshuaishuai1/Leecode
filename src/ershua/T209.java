package ershua;

public class T209 {
    public int minSubArrayLen(int target, int[] nums) {
        int fast = 0;
        int slow = 0;
        int sum  = 0;
        int ret = Integer.MAX_VALUE;
        while (slow < nums.length && fast < nums.length){
            if (sum >= target) {
                if (fast == slow) {
                    ret = 1;
                }else {
                    ret = Math.min(ret,fast - slow -1 );
                }
                sum -= nums[slow++];
            }else {
                sum += nums[fast++];
            }
        }
        return ret==Integer.MAX_VALUE ? 0:ret;
    }

    public static void main(String[] args) {
        T209 t209 = new T209();
        System.out.println(t209.minSubArrayLen(4, new int[]{1,4,4}));

    }
}
