package wy;

import java.util.Arrays;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int len1 = n / 2,len2;
            if (n % 2== 0) {
                len2 = len1;
            }else {
                len2 = len1+1;
            }
            int[] arr1 = new int[len1];
            int[] arr2 = new int[len2];
            int idx1=0, idx2 = 0;
            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    arr2[idx2] = scanner.nextInt();
                    idx2++;
                }else {
                    arr1[idx1] = scanner.nextInt();
                    idx1++;
                }
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            for (int j = 0; j <n; j++) {
                int bb = 1;
            }
            boolean is = false;
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[j] > arr1[j]) {
                    System.out.println("NO");
                    is=true;
                    break;
                }
            }
            if (is) {
                continue;
            }
            if (arr2[arr2.length-1] < arr1[arr1.length-1] &&  arr2.length > arr1.length ){
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
