package hash;

import java.util.HashMap;

public class T454_hash_plus {
//    利用两两数组分开将四数之和转换为两数之和

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num:
             nums1) {
            for (int num2:
                 nums2) {
                int temp = num + num2;
                if (hashMap.containsKey(temp)) {
                    hashMap.put(temp, hashMap.get(temp) + 1);
                }else {
                    hashMap.put(temp, 1);
                }
            }
        }

        int count = 0;
        for (int num3:
             nums3) {
            for (int num4:
                 nums4) {
                int temp = num3 + num4;
                if (hashMap.containsKey(0 - temp)) {
                    count += hashMap.get(0-temp);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        T454_hash_plus t454_hash_plus = new T454_hash_plus();
//        int i = t454_hash_plus.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});
        int i = t454_hash_plus.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});

        System.out.println(i);
    }
}
