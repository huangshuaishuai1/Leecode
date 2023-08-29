package dewu;

import java.util.Scanner;

public class T {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 房子数
        int m = scanner.nextInt(); // 总高度
        int x = scanner.nextInt(); // 返回结果的下标，从1开始
        if(n == m) {
            System.out.println(1);
            return;
        }
        int ans = 2;
        int total = n + 1;
        int lMax = x - 1;
        int rMax = n - x;
        int l = 0;
        int r = 0;

        while (total < m) {
            ans++;
            total++;
            l++;
            l = Math.min(l,lMax);
            r++;
            r = Math.min(r,rMax);
            total+=l;
            total+=r;
            if (total > m) {
                System.out.println(ans-1);
                return;
            }
        }
        System.out.println(ans);
    }
}
