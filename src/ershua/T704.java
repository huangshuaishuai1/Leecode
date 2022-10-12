package ershua;

public class T704 {

    public int search(int[] nums, int target) {
        int pre = 0;
        int beh = nums.length-1;
        while(pre <= beh) {

            int mid = (pre+ beh) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target){
                beh = mid - 1;
            }else {
                pre = pre + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        T704 t704 = new T704();
        System.out.println(t704.search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
