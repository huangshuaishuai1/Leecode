package ershua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        ArrayList<List<Integer>> ret = new ArrayList<>();
        help(0,nums.length-1,ret,nums,target);
        return ret;
    }
    void help(int front, int behind, ArrayList<List<Integer>> ret,int[] nums, int target ) {
        if (behind - front < 3) {
            return;
        }
        int move1 = front + 1;
        int move2 = behind - 1;

        while (move1 < move2) {
            if (move1 > front + 1 && move2 <behind-1 && nums[move1] == nums[move1 - 1] && nums[move2] == nums[move2 + 1]) {
                move1 ++;
                move2 --;
                continue;
            } else if (move1 > front + 1 &&  nums[move1] == nums[move1 - 1]) {
                move1++;
                continue;
            }else if (move2 <behind-1 && nums[move2] == nums[move2 + 1]) {
                move2 --;
                continue;
            }
            // 如果相加等于target，就加入到结果集中
            if (nums[front] + nums[move1] + nums[move2] + nums[behind] == target) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[front]);
                list.add(nums[move1]);
                list.add(nums[move2]);
                list.add(nums[behind]);
                if (!ret.contains(list)) {

                    ret.add(list);
                }
                move1++;
                move2--;
            }
            // 如果小于，move1往后移动
            else if (nums[front] + nums[move1] + nums[move2] + nums[behind] < target) {
                move1 += 1;
            }else {
                move2 -= 1;
            }
        }
        int new_front = front + 1;
        while (new_front < nums.length&&nums[new_front] == nums[front]  ) {
            new_front++;
        }
        int new_behind = behind - 1;
        while (new_behind > 0&&nums[new_behind] == nums[behind]  ) {
            new_behind -- ;
        }

        help(new_front,behind,ret,nums,target);
        help(front,new_behind,ret,nums,target);
    }

    public static void main(String[] args) {
        T18 t18 = new T18();
        List<List<Integer>> lists = t18.fourSum(new int[]{2,2,2,2,2}, 8);
        System.out.println(111);

    }
}
