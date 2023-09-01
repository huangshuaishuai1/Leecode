package hot100;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class T239 {

    public static void main(String[] args) {
        T239 t239 = new T239();
        int[] ints = t239.maxSlidingWindow(new int[]{1,-1}, 1);
        System.out.println(111);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int len = 0;
        for (int i = 0; i < k; i++) {
            if (deque.size()!=0 && nums[i] >= deque.peekLast()) {
                deque.clear();
            }
            deque.addFirst(nums[i]);
            if (deque.size() > k) {
                deque.removeLast();
                while (deque.size()>1 && deque.peekLast() <= nums[i]) {
                    deque.removeLast();
                }
            }
        }
        ans[len++] = deque.peekLast();
        for (int i = k; i < nums.length; i++) {
            if (deque.size()!=0 && nums[i] >= deque.peekLast()) {
                deque.clear();
            }
            deque.addFirst(nums[i]);
            if (deque.size() > k) {
                deque.removeLast();
                while (deque.size()>1 && deque.peekLast() <= nums[i]) {
                    deque.removeLast();
                }
            }
            ans[len++] = deque.peekLast();
        }
        return ans;
    }
}
