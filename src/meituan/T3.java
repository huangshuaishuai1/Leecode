package meituan;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int oprate = 2;

        char[] array = s.toCharArray();

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] == array[end]) {
                start++;
                end--;
                continue;
            }
            else {
                if (array[start] < array[end]) {
                    array[end] = array[start];
                    oprate--;
                }else {
                    array[start] = array[end];
                    oprate--;
                }
            }
            start++;
            end--;
        }
        if (oprate == 2) {
            start = 0;
            end = array.length-1;
            while ((start < end) && oprate > 0) {
                if (array[start] != 'a') {
                    array[start] = 'a';
                    array[end] = 'a';
                    oprate-=2;
                }
                start++;
                end--;
            }
        }

        String ret = new String(array);
        System.out.println(ret);


    }
}
