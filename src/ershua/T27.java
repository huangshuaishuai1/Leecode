package ershua;

public class T27 {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast++];
            }else {
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        T27 t27 = new T27();
        System.out.println(t27.removeElement(new int[]{},2));
    }
}
