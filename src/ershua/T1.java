package ershua;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1 {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            ret[0] = i;
            int tmp = target - nums[i];
            if (list.contains(tmp)) {
                if (list.lastIndexOf(tmp) > i) {

                    ret[1] = list.lastIndexOf(tmp);
                    return ret;
                }

            }

        }
        return ret;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        int[] ints = t1.twoSum(new int[]{3,2,4}, 6);
        System.out.println(111);
    }
}
