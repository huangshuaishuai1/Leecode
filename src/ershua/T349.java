package ershua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class T349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set1.contains(nums1[i])) {
                set1.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                ret.add(nums2[i]);
                set1.remove(nums2[i]);
            }
        }
        int[] ints = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            ints[i] = ret.get(i);
        }
        return ints;
    }

}
