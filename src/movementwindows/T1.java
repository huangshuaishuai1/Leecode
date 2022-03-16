package movementwindows;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class T1 {


    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            if (sum < s) {
                sum += nums[right++];
//            } else if (left < right){
//                result = Math.min(right - left, result);
//                sum -= nums[left++];
            }
            while (sum >= s && left <= right) {
                result = Math.min(right - left, result);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ?  0 : result;
    }


    public static void main(String[] args) {
        T1 f = new T1();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = f.minSubArrayLen(7, nums);
        System.out.println(i);
    }
}
