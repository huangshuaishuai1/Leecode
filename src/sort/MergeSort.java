package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 1, 6, 5};
        System.out.println(Arrays.toString(nums));
        int[] tmp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,tmp);
        System.out.println(Arrays.toString(nums));

    }

    private static void mergeSort(int[] nums, int left, int right, int[] tmp) {
       if (left < right) {
           int mid = (left + right) / 2;
           mergeSort(nums,left,mid,tmp);
           mergeSort(nums,mid+1,right,tmp);
           merge(nums,left,mid,right,tmp);
       }

    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int l = left;
        int r = mid+1;
        int tmpInt = 0;
        while (l <= mid && r <= right) {
            if (nums[l] < nums[r]) {
                tmp[tmpInt++] = nums[l];
                l++;
            }else {
                tmp[tmpInt++] = nums[r];
                r++;
            }
        }
        // 如果一个先到最后
        while (l <= mid) {
            tmp[tmpInt++] = nums[l];
            l++;
        }
        while (r <= right) {
            tmp[tmpInt++] = nums[r];
            r++;
        }
        tmpInt = 0;
        while (left <= right) {
            nums[left++] = tmp[tmpInt++];
        }
    }
}
