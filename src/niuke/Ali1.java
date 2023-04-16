package niuke;

import java.util.Scanner;

public class Ali1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 31; i >=0 ; i--) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < N; j++) {
                int n = number[j] >> i;
                if (n == 0) {
                    zero++;
                }else {
                    one++;
                }
                number[j] %= (int) Math.pow(2,i);
            }
            count += Math.min(one,zero);
        }
        System.out.println(count);
    }
}
