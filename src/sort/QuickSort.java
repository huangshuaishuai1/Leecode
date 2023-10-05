package sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 1, 6, 5};
        System.out.println("before");
        printNum(nums);
        quickSort(nums,0,nums.length-1);
        System.out.println();
        System.out.println("after");
        printNum(nums);
    }

    public static void quickSort(int[] nums, int start, int end) {

        if ( nums == null||nums.length == 0 || end <= start) {
            return;
        }
        int mid = partition(nums,start,end);
        quickSort(nums,start,mid-1);
        quickSort(nums,mid+1,end);
    }

    private static int partition(int[] nums, int start, int end) {

        int p = nums[start];
        while (end > start) {
            while (end > start && nums[end] > p) {
                end--;
            }
            if (end > start) {
                nums[start] = nums[end];
                start++;
            }
            while (end > start && nums[start] < p) {
                start++;
            }
            if (end > start) {
                nums[end] = nums[start];
                end--;
            }
        }
        nums[end] = p;
        return end;
    }


    public static void printNum(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
