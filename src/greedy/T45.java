package greedy;

public class T45 {
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int count = 1;
        int scope = nums[0];
        while (true) {
            if (scope >= nums.length - 1) {
                return count;
            }
            int max = scope;
            for (int i = count; i <= max; i++) {
                scope = Math.max(scope,i+nums[i]);
            }
            count ++;
        }

    }

    public static void main(String[] args) {
        T45 t45 = new T45();
        System.out.println(t45.jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
}
