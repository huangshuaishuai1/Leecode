package huawei.qiuzhao;

import java.util.Scanner;

public class T11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();  // M分钟
        int N = scanner.nextInt();  // 最大N个请求
        int X = scanner.nextInt();
        int[] req = new int[X];
        for (int i = 0; i < X; i++) {
            req[i] = scanner.nextInt();
        }
        int ans = 0;
        int[] pre = new int[X + 1];
        pre[0] = 0;
        for (int i = 0; i < X; i++) {
            pre[i + 1] = pre[i] + req[i];
        }

        for (int i = M; i < pre.length; i++) {
            int l = i - M;
            if ( pre[i] - pre[l] - ans > N) {
                ans +=  (pre[i] - pre[l]) - ans - N;
            }

        }
        System.out.println(ans);

    }
}
