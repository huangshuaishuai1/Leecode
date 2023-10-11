package huawei.qiuzhao;

import java.util.Scanner;

public class T1 {

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
        int sum = 0;
        for (int i = 0; i < M; i++) {
            sum += req[i];
        }
        for (int i = M - 1; i < X; i++) {
            int tmp = i;
            ans += Math.max(sum - N, 0);
            while (sum > N) {
                if (req[tmp] > sum - N) {
                    req[tmp] -= (sum - N);
                    sum -= (sum - N);
                } else {
                    sum -= req[tmp];
                    req[tmp] = 0;
                }
            }
            sum -= req[i - M + 1];
            if (i + 1 < X){
                sum += req[i + 1];
            }
        }
        System.out.println(ans);

    }
}
