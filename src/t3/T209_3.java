package t3;

public class T209_3 {
    public static void main(String[] args) {
        T209_3 t209_3 = new T209_3();
        int ret = t209_3.minSubArrayLen(11, new int[] {11,11,11,11,11,11,11,111});
        System.out.println(ret);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ret = nums.length+1;
        int length = nums.length;
        while(j < length){
            while (sum < target && j <length) {
                sum += nums[j++];
            }
            while (sum >= target) {
                ret = Math.min(ret,j - i);
                sum -= nums[i++];
            }
        }
        System.out.println(i);
        System.out.println(j);
        if (ret == length + 1) {
            ret = -1;
        }
        return ret;
    }
}
