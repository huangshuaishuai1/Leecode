package shine;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int[] time = new int[line];
        int[] req = new int[line];
        for (int i = 0; i < line; i++) {
            time[i] = scanner.nextInt();
            req[i] = scanner.nextInt();
        }
        int ans = 0;
        int total = 100;

        for (int i = 0; i < line; i++) {
            int j = i-1;
            int gap = 0;
            if (j < 0) {
                gap = 0;
            }else {
                gap = time[j];
            }
            total += (time[i] - gap)  / 10;
            if (total > 150) {
                total = 150;
            }
            ans += req[i] - Math.min(total,req[i]);
            total = Math.max(0,total-req[i]);
        }
        System.out.println(ans);
    }
}
