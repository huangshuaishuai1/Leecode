package metting.meituan;


import java.util.Arrays;
import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        helper();
    }

    static void helper() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        double[] ret = new double[k];

        Arrays.sort(ints);
        for (int i = 0; i < n; i++) {
            int pos = i / k ;  // 子序列中有几个元素
            int offset = i % k;  // 放入第几个子序列中去

            ret[offset] = (ret[offset] * pos + ints[i]) / (pos + 1);
        }
        double sum = 0;
        sum = Arrays.stream(ret).sum();
        // 输出最小平均数
        System.out.println(sum);
    }


}
