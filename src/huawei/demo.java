package huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        int left = -1;
        int right = -1;
        int maxRight = -1;
        int abc = 0;
        int[] a = new int[1000001];
        int[] b = new int[1000001];
        abc++;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            left = scanner.nextInt();
            right = scanner.nextInt();
            a[left]++;
            b[right]++;
            maxRight = Math.max(right,maxRight);
        }
        int c = 0;
        long ret = 0;
        int tag = 0;
        for (int i = 1; i <= maxRight; i++) {
            if (a[i] != 0) {
                c += a[i];
            }
            abc--;
            if (b[i-1] != 0) {
                c -= b[i-1];
            }
            if (c == 0) {
                if (tag==0) {
                    continue;
                }else {
                    ret+=1;
                }
            }else if (c == 1) {
                tag = 1;
                ret+=3;
            }else {
                ret+=4;
            }
        }
        System.out.println(ret);
    }
}
