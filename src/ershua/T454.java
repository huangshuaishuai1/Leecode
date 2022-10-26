package ershua;

import java.util.HashMap;
import java.util.Set;

public class T454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 第一次，计算nums1和nums2
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (!map1.containsKey(nums1[i] + nums2[j])) {
                    map1.put(nums1[i] + nums2[j],1);
                }else {
                    map1.put(nums1[i] + nums2[j],map1.get(nums1[i] + nums2[j])+1);
                }
            }
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums4.length; i++) {
            for (int j = 0; j < nums3.length; j++) {
                if (!map2.containsKey(nums3[i] + nums4[j])) {
                    map2.put(nums3[i] + nums4[j],1);
                }else {
                    map2.put(nums3[i] + nums4[j],map2.get(nums3[i] + nums4[j])+1);
                }
            }
        }
        int ret = 0;
        Set<Integer> integers = map1.keySet();
        for (Integer key:
             integers) {
            int tmp = -key;
            if (map2.containsKey(tmp)) {
                ret += map1.get(key) * map2.get(tmp);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T454 t454 = new T454();
        System.out.println(t454.fourSumCount(
                new int[]{-1,-1},
                new int[]{-1,1},
                new int[]{-1,1},
                new int[]{1,-1}
        ));
    }
}
