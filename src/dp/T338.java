package dp;

public class T338 {

    public static void main(String[] args) {
        T338 t338 = new T338();
        int[] ints = t338.countBits(5);
        System.out.println(111);
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            int tem = i;
            while (tem > 0) {
                ans[i] += tem & 1;
                tem >>= 1;
            }
        }
        return ans;
    }
}
