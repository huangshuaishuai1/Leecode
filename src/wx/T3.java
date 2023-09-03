package wx;
import java.util.Scanner;
public class T3 {
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
        double target = (double) u / v;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            double aa = i * target;
            if (aa != (int) aa) {
                continue;
            }
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += numbers[j];
            }
            if (sum == aa) {
                ans++;
            }
            for (int j = i; j < n; j++) {
                sum -= numbers[j-i];
                sum += numbers[j];
                if (sum == aa) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

}
