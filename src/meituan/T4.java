package meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int[] price = new int[N];
        int[] discount = new int[N];
        int[] index = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = scanner.nextInt();
            discount[i] = scanner.nextInt();
            index[i] = i;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N-i-1; j++) {
                if (discount[j] > discount[j+1]) {
                    int tem = discount[j];
                    discount[j] = discount[j+1];
                    discount[j+1] = tem;
                    tem = index[j];
                    index[j] = index[j+1];
                    index[j+1] = tem;
                }
            }
        }
        int[] priceNow = new int[N];

        for (int i = 0; i < Y; i++) {
            priceNow[index[i]] = discount[i];
        }
        for (int i = 0; i < N; i++) {
            if (priceNow[i] == 0) {
                priceNow[i] = price[i];
            }
        }
        Arrays.sort(priceNow);
        int ret = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + priceNow[i] <= X) {
                sum+=priceNow[i];
                ret++;
            }
        }
        System.out.println(ret+" "+sum);
    }

}
