package xiecheng;

import java.util.ArrayList;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int length = number.length();
        int a = 0;
        int b = 0;
        for (int i = 0; i < length-1; i++) {
            if (Integer.valueOf(number.charAt(i)) % 2 == 0) {
                a ++;
            }else {
                b++;
            }
        }
        Integer c = Integer.valueOf(number.charAt(length-1));
        if (c % 2 == 0) {
            System.out.println(a);
        }else {
            System.out.println(b);
        }


    }
}
