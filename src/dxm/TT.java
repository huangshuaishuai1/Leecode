package dxm;

public class TT {
    public static void main(String[] args) {
        func(new int[]{1,0,2});
    }

    public static void func(int[] scores) {
        int n = scores.length;
        int ans = 0;
        int[] candy = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && scores[i] > scores[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && scores[i] > scores[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            candy[i] = Math.max(candy[i], right);
            ans += candy[i];
        }
        System.out.println(ans);
        for (int i = 0; i < n; i++) {
            System.out.print(candy[i] + " ");
        }
    }
}
