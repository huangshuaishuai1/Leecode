package xy;

import java.util.Scanner;

public class T2 {
static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        int m = scanner.nextInt();
        int[] goods = new int[m];
        for (int i = 0; i < m; i++) {
            goods[i] = scanner.nextInt();
        }
        int[] used = new int[m];
        func(goods,capacity,m,0,used,0);

        System.out.println(ans);
    }

    static void func(int[] goods, int capacity, int m, int sum,int[] used,int startIdx) {
        if (sum == capacity) {
            ans++;
            return;
        }
        for (int i = startIdx; i < m; i++) {
            sum += goods[i];
//            used[i] = 1;
            func(goods,capacity,m,sum,used,i+1);
            sum-=goods[i];
        }

    }
}
