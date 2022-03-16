package array;

public class t_367 {

    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        t_367 t_367 = new t_367();
        int num = 121;
        boolean perfectSquare = t_367.isPerfectSquare(num);
        System.out.println(perfectSquare);
    }
}
