package ershua;

import java.util.ArrayList;
import java.util.Collections;

public class T239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        // 初始化它
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        int[] ret = new int[nums.length - k + 1] ;
        Collections.sort(list);
        int max = list.get(k-1);
        for (int i = k; i < nums.length; i++) {
            ret[i-k] = max;
            Integer now = list.remove(list.indexOf(nums[i - k]));
            list.add(0,nums[i]);
            if (now == max || nums[i] > max) {
                // 不需要每次都排序，只在最大值变化了之后出去了之后排序
                Collections.sort(list);
                max = list.get(k-1);
            }
        }
        ret[ret.length-1] = list.get(k-1);
        return ret;
    }

    public static void main(String[] args) {
        T239 t239 = new T239();
        System.out.println(t239.maxSlidingWindow(new int[]{
                1,-1}, 1));
    }
}
