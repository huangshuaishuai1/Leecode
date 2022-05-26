package stack;

import java.util.Deque;
import java.util.LinkedList;

public class T239plus {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int num = 0;
        MyQueue myQueue = new MyQueue();
        int[] ret = new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        ret[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
            ret[num++]=myQueue.peek();
        }
        return ret;
    }

    public static void main(String[] args) {
        T239plus t239plus = new T239plus();
        int[] ints = t239plus.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i:
             ints) {
            System.out.println(i);
        }
    }
}
class MyQueue {
    Deque<Integer> deque = new LinkedList<>();
    void poll(int val) {
        if (!deque.isEmpty() && deque.peek() == val) {
            deque.poll();
        }
    }

    void add(int val) {
        while (!deque.isEmpty() && val>deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }
    int peek() {
        return deque.peek();
    }
}
