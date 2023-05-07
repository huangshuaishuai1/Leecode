package meituan;

import java.util.Scanner;

@SuppressWarnings("all")
public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();
        String[] left = new String[n];
        String[] right = new String[n];
        for (int i = 0; i < n; i++) {
            left[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            right[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            int temp = 0;
            if (left[i].charAt(0) == '*' && right[i].charAt(0) == '*') {
                boolean canLeft = false;
                boolean canRight = false;
                if (Long.parseLong(left[i].substring(1)) <= k) {
                    canLeft = true;
                }
                if (Long.parseLong(right[i].substring(1)) <= k) {
                    canRight = true;
                }
                if (canLeft && canRight) {
                    k = k + Math.max(Long.parseLong(left[i].substring(1)), Long.parseLong(right[i].substring(1)));
                } else if (canLeft) {
                    k += Long.parseLong(left[i].substring(1));
                } else if (canRight) {
                    k += Long.parseLong(right[i].substring(1));
                } else {
                    System.out.println(-1);
                    return;
                }
            } else if (left[i].charAt(0) == '*' && right[i].charAt(0) != '*') {
                if (Long.parseLong(left[i].substring(1)) <= k) {
                    k = Math.max(k + Long.parseLong(left[i].substring(1)), myHandle(right[i], k));
                } else {
                    k = myHandle(right[i], k);
                }
            } else if (left[i].charAt(0) != '*' && right[i].charAt(0) == '*') {
                if (Long.parseLong(right[i].substring(1)) <= k) {
                    k = Math.max(k + Long.parseLong(right[i].substring(1)), myHandle(left[i], k));
                } else {
                    k = myHandle(left[i], k);
                }
            } else {
                k = Math.max(myHandle(left[i], k), myHandle(right[i], k));
            }
        }
        System.out.println(k);
    }


    private static long myHandle(String s, long k) {
        if (s.charAt(0) == '-') {
            return k - Long.parseLong(s.substring(1));
        } else if (s.charAt(0) == '+') {
            return k + Long.parseLong(s.substring(1));
        } else {
            return k / Long.parseLong(s.substring(1));
        }
    }
}