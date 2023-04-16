package base;

import java.util.Arrays;

public class ErFen {

    public static void main(String[] args) {
        int[] number = {1,2,4,8,10,15,64,77,88};
        int target = 1;
        int idx = binarySearch(number,8111);
        System.out.println(idx);

    }

    private static int binarySearch(int[] number, int target) {
        int pre = 0;
        int beh = number.length-1;
        int mid = 0;
        while (pre <= beh) {
            mid = (pre+beh) >>> 1;
            if (number[mid] == target) {
                return mid;
            }
            if (number[mid] < target) {
                pre = mid+1;

            }else {
                beh = mid-1;
            }
        }
        return -1;
    }

}
