package ershua;

public class T45 {
    public static void main(String[] args) {
        T45 t45 = new T45();
        System.out.println(t45.jump(new int[]{1, 1, 1, 1}));
    }
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 1;
        int pre = 0;
        int now = nums[0];
        while (now < nums.length-1){
            int tmp = 0;
            for (int i = pre+1; i <= now; i++) {
                tmp = Math.max(tmp,i+nums[i]);
                if (tmp >= nums.length-1) {
                    return count+1;
                }
            }
            pre=now;
            now = tmp;
            count++;
        }
        return count;
    }
}
