package niuke;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ZiJie2 {
    static long ret;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[i] = scanner.nextInt();
        }
        Arrays.sort(pos);
        int end = 1;
        int count = 0;
        for (int i = 0; i < pos.length-2; i++) {
            for (int j = end; j < pos.length; j++) {
                if (pos[j] - pos[i] <= d) {
                    count++;
                    end++;
                }else {
                    break;
                }
            }
            helper(count);
            count--;
        }
        System.out.println(ret % 99997867);
    }

    static void helper(long count) {
        long tmp=  count * (count - 1);

        ret += tmp/2;
    }

}
