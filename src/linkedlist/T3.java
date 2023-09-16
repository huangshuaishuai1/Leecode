package linkedlist;

import java.util.LinkedList;

public class T3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        int[] q = t3.findQ(8, new int[]{10, 20, 20, 99, 20, 99, 100, 100});
        System.out.println(111);
    }

    public int[] findQ (int n, int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }else {
                list.remove(list.indexOf(nums[i]));

                list.add(nums[i]);
            }
        }
        int[] ints = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }

        return ints;
    }
}
