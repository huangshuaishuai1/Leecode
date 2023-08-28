package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T15 {
    public static void main(String[] args) {
        T15 t15 = new T15();
        List<List<Integer>> lists = t15.threeSum(new int[]{-2,0,1,1,2});
        System.out.println(111);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int sum = nums[i];
            if (sum > 0) {
                break;
            }
            // 固定第一个数
            // 第二个数为nums[i+1]
            int left = i+1;
            // 第三个数为nums[len-1]
            int right = nums.length-1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp + sum == 0) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[left]);
                    arrayList.add(sum);
                    arrayList.add(nums[right]);
                    ans.add(arrayList);
                    while (left < nums.length-1 && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (right > i  && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }else if (tmp < 0) {
                    left++;
                }else if (tmp > 0) {
                    right--;
                }
            }
        }

        return ans;
    }
}
