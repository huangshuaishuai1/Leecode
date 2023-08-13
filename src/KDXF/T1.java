package KDXF;

public class T1 {

    public static void main(String[] args) {


    }

    public void m(int n) {
        // n + 1 = a_{ai} + a_i
        int[] ans = new int[n+1];

        ans[1] = n;
        ans[n] = n+1-ans[1];

        // 5 4 3 2 1

        for (int i = n; i >= 1; i--) {
            System.out.println(i+" ");
        }

    }
}
