package stack;

import java.util.LinkedList;
import java.util.Queue;

public class T239 {
    // 超时了
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length-k+1];

        Queue<Integer> queue = new LinkedList<>();
        // 先把前k个数放进队列
        for (int i = 0; i < ret.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                queue.add(nums[j]);
                max = Math.max(max,nums[j]);
                ret[i] = max;
            }

            queue.clear();
        }

        return ret;
    }

    public static void main(String[] args) {
        T239 t239 = new T239();
        int[] ints = t239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i:ints) {
            System.out.println(i);
        }
    }
}
