package hot100;

public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int target = total / 2;
        // target 是双数，就要取 target 和 target-1 两个位置的平均，是单数就取target位置的数
        int i = 0;
        int j = 0;
        int k = 0;
        int ret[] = new int[2];
        while((i < nums1.length || j < nums2.length) && k <= target) {
            int temi = Integer.MAX_VALUE;
            int temj = Integer.MAX_VALUE;
            if(i < nums1.length) {
                temi = nums1[i];
            }

            if(j < nums2.length) {
                temj = nums2[j];
            }

            if(temi < temj) {
                i++;
            }else {
                j++;
            }

            if(target == k) {
                ret[0] = Math.min(temi,temj);
            }
            if (target-1 == k) {
                ret[1] = Math.min(temi, temj);
            }
            k++;
        }
        if(total % 2 == 1) {
            return (double)ret[0];
        }else {
            return ((double)(ret[0]+ret[1]) / 2);
        }

    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        System.out.println(t4.findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4,5}));
    }

}
