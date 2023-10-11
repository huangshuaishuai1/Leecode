package huawei.qiuzhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String[] strs = str.split(","); // 将字符串按照 , 分割

        int[] books = new int[strs.length];
        int count = 0; // 负数的总数
        
        // 将字符串转换为整数
        for (int i = 0; i < strs.length; i++) {
            books[i] = Integer.parseInt(strs[i]);
            if (books[i] < 0) {
                count ++;
            }
        }

        Arrays.sort(books); // 排序

        int ans = 0;
        int max = 0;
        int sum = 0;
        int negativeSum = 0;
        for (int i = count; i < books.length; i++) {
            ans += (books[i] * (i +1-count));
            sum += books[i];
        }
        max = ans;
        for (int i = count-1; i >= 0; i--) {
            ans += sum;
            ans += negativeSum;
            ans += books[i];
            negativeSum += books[i];
            if (max > ans) {
                break;
            }else {
                max = ans;
            }

        }

        System.out.println(max);

    }
}
