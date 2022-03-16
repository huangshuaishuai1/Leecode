package array;

public class t_69 {

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long mid = (left + right) / 2;
        while(true) {
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int)mid;
            } else if ((mid + 1) * (mid + 1) <= x) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else if (mid * mid > x && (mid - 1) * (mid - 1) <= x) {
                return (int)mid - 1;
            } else if ((mid-1) * (mid - 1) > x) {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }
    }

    public static void main(String[] args) {
        t_69 f = new t_69();
        int i = f.mySqrt(2147395599);
        System.out.println(i);
    }
}
