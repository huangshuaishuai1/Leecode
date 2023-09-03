package wx;

import java.util.Scanner;

public class T33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int u = scanner.nextInt();
        int v = scanner.nextInt();
        // u / v
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int[] aa = new int[n+1];
        System.out.println(helper(aa,numbers,n,u,v));

    }

    public static int helper(int[] aa, int[] numbers, int n, int u, int v) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            aa[i+1] = aa[i] + numbers[i];
        }
        for (int i = 0; i < n; i++) {
            int c = i;
            int idex = 1;
            while (c+idex*v<=n) {
                int nowSum = aa[c+idex * v] - aa[c];
                int sz = idex * v;
                if (nowSum * v == sz * u) {
                    ans++;
                }
                idex ++;
            }
        }
        return ans;
    }
}
