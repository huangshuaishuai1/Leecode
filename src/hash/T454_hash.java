package hash;

import jdk.nashorn.internal.ir.CallNode;

import java.util.HashMap;


public class T454_hash {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 将每个数组都映射到一个hashmap种 键表示数值， 值表示 该数值出现的频率 （num：frequency）
//         超出时间限制 ，可以缩小数组中出现大量重复数字的情况的运行时间，没有解决四次for循环的本质
        HashMap<Integer, Integer> projcet1 = projcet(nums1);
        HashMap<Integer, Integer> projcet2 = projcet(nums2);
        HashMap<Integer, Integer> projcet3 = projcet(nums3);
        HashMap<Integer, Integer> projcet4 = projcet(nums4);
        int[] key1 = toIntArray(projcet1.keySet().toArray());
        int[] key2 = toIntArray(projcet2.keySet().toArray());
        int[] key3 = toIntArray(projcet3.keySet().toArray());
        int[] key4 = toIntArray(projcet4.keySet().toArray());
        int count = 0;
        for (int i = 0; i < key1.length; i++) {
            for (int j = 0; j < key2.length; j++) {
                for (int k = 0; k < key3.length; k++) {
                    for (int l = 0; l < key4.length; l++) {
                        if (key1[i] + key2[j] + key3[k] + key4[l] == 0){
                            count += (projcet1.get(key1[i]) * projcet2.get(key2[j]) *
                                    projcet3.get(key3[k]) * projcet4.get(key4[l]));
                        }
                    }
                }
            }
        }
        return count;
    }
    public static HashMap<Integer, Integer> projcet(int[] nums) {
        HashMap<Integer, Integer> projection = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (projection.containsKey(nums[i])) {
                projection.put(nums[i], projection.get(nums[i]) + 1);
            }else {
                projection.put(nums[i], 1);
            }
        }
        return projection;
    }

    public static int[] toIntArray(Object[] objs) {
        int[] ints = new int[objs.length];
        for (int i = 0; i < objs.length; i++) {
            ints[i] = (int)objs[i];
        }
        return ints;
    }

    public static void main(String[] args) {
        T454_hash t454_hash = new T454_hash();
//        int i = t454_hash.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});
        int i = t454_hash.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println(i);
    }
}
