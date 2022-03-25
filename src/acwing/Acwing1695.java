package acwing;

import java.util.Scanner;

public class Acwing1695 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        int[][] exchanges = new int[times][3];
        for (int i = 0; i < times; i++) {
            // 在当前位置下要互换的两个下标
            exchanges[i][0] = scanner.nextInt();
            exchanges[i][1] = scanner.nextInt();
            // 也是相对现在位置的猜想
            exchanges[i][2] = scanner.nextInt();
        }
        // 分三种情况  也就是坚果壳初始在哪个下面
        int ret1 = findIt(exchanges, 1, times);
        int ret2 = findIt(exchanges, 2, times);
        int ret3 = findIt(exchanges, 3, times);
        int ret = Math.max(ret1, Math.max(ret2,ret3));
        System.out.println(ret);
    }
    public static int findIt(int[][] exchanges, int position, int times) {
        // 正确次数
        int count = 0;
        for (int i = 0; i < times; i++) {
            if (position == exchanges[i][0]) {
                position = exchanges[i][1];
            }else if (position == exchanges[i][1]) {
                position = exchanges[i][0];
            }
            if (position == exchanges[i][2]) {
                count ++;
            }
        }
        return count;
    }
}
