package stack;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class T347 {
    // map + 优先队列
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer,Integer> entry:
             entries) {
            queue.offer(entry);
            if (queue.size()>k){
                queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        T347 t347 = new T347();
        int[] ints = t347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i:
             ints) {
            System.out.println(i);
        }
    }

}
