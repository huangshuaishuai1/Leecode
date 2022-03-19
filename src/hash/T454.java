package hash;



// 暴力解法，超时。
public class T454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                      if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                          count++;
                      }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        T454 t454 = new T454();
        int i = t454.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});
        System.out.println(i);
    }
}
