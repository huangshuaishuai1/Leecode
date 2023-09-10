package didi;

import java.math.BigInteger;
import java.util.Scanner;

public class DD1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 种类数
        int a = scanner.nextInt();  // a包
        int b = scanner.nextInt();  // 最小b个

        int[] c = new int[n];
        int[] ac = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        int l = 0;
        int r = 20;
        int mid = 0;
        while (l <= r) {
            mid = (l+r) / 2;
            if (func(c,mid,b,a)) {
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        System.out.println(r+1);
    }
    public static boolean func(int[] c, int num, int b, int a) {
        BigInteger aa = new BigInteger(String.valueOf(a));
        BigInteger sum = new BigInteger("0");
        for (int i : c) {
            BigInteger bigInteger = new BigInteger(String.valueOf(i*num/b));
            sum = sum.add(bigInteger);
        }

        if (sum.compareTo(aa) >= 0) {
            return true;
        }else {
            return false;
        }
    }
}
