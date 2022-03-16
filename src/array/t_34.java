package array;

public class t_34 {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) >> 1;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        while (left <= right && (nums[left] != target || nums[right] != target)){
            if (nums[left] > target || nums[right] < target) {
                return new int[]{-1, -1};
            }
            if (nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) >> 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
                mid = (left + right) >> 1;
            } else {
                left = mid;
                right = mid;
                System.out.println(mid);
                while (left > 0 && nums[left - 1] == target) {
                    left --;
                }
                while (right < nums.length && nums[right + 1] == target) {
                    right ++;
                }

            }
        }

        return new int[] {left, right};
    }

    public static void main(String[] args) {
        t_34 f = new t_34();
        int[] nums = {1, 2 , 2};
        int target = 1;
        int[] results = f.searchRange(nums, target);
//        System.out.println();
        System.out.println("(" + results[0] + "," + results[1] + ")");
    }
}
