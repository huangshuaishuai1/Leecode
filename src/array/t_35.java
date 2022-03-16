package array;

public class t_35 {
    // 左闭右闭
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) >> 1;
//            if (target < nums[left]) {
//                return left;
//            }else if(target > nums[right]) {
//                return right + 1;
//            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        t_35 f = new t_35();
        int result = f.searchInsert(nums, target);
        System.out.println(result);
    }
}
