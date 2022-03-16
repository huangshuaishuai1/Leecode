package array;

public class t_704 {

    public int adjust(int[] nums, int target, int front, int mid, int behind) {
        if (nums[front] == target) {
            return front;
        }
        if (nums[behind] == target) {
            return behind;
        }
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            if (mid == front || mid == behind) {
                return -1;
            } else {
                front = mid;
                mid = (behind + front) / 2;
                return adjust(nums, target, front, mid, behind);
            }
        } else {
            if (mid == front || mid == behind) {
                return -1;
            } else {
                behind = mid;
                mid = (behind + front) / 2;
                return adjust(nums, target, front, mid, behind);
            }

        }
    }

    public int search(int[] nums, int target) {
        int fornt = 0;
        int behind = nums.length - 1;
        int mid = (behind + fornt) / 2;
        if (target < nums[0] || target > nums[nums.length-1]) {
            return -1;
        } else {
            return adjust(nums, target, fornt, mid, behind);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5};
        int target = 5;
        t_704 f = new t_704();
        int result = f.search(nums, target);
        System.out.println(result);
    }
}
