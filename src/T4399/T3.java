package T4399;

public class T3 {
    public static void main(String[] args) {
        System.out.println(T3.ans(new int[]{23, 2, 6, 4, 7}, 6));
    }

    public static boolean ans(int[] num, int k) {

        for (int i = 0; i < num.length; i++) {
            int sum = num[i];
            for (int j = i+1; j < num.length; j++) {
                sum += num[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getSum(int[] num, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += num[i];
        }
        return sum;
    }

}
