package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 1, 6, 5};
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length-1; i > 0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            heapify(nums,i,0);
        }
    }

    // 建大顶堆
    // l = root * 2 + 1   r = root * 2 + 2
    static void buildHeap(int[] nums) {
        for (int i = (nums.length-2) / 2; i >= 0; i--) {
            heapify(nums, nums.length,i);
        }
    }

    // 维护堆
    static void heapify(int[] nums, int len, int target) {
        int l = target * 2 + 1;
        int r = target * 2 + 2;
        int largest = target;

        if (l < len && nums[l] > nums[largest]) {
            largest = l;

        }
        if (r < len && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != target) {
            // 交换largest和target位置的值
            int tmp = nums[largest];
            nums[largest] = nums[target];
            nums[target] = tmp;
            // 递归维护largest处
            heapify(nums,len,largest);
        }
    }

}
