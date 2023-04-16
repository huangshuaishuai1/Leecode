package acwing;

import java.util.Scanner;

public class Acwing4469 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 1; i < s1.length(); i++) {
            String a = s1.substring(i-1,i);
            String b = s1.substring(i,i+1);
            int numerA = Integer.parseInt(a);
            int numerB = Integer.parseInt(b);
            if ( numerA% 2 == numerB%2) {
                if (numerA > numerB) {
                    sb1.append(a);
                }else {
                    sb1.append(b);
                }
            }
        }
        for (int i = 1; i < s2.length(); i++) {
            String a = s2.substring(i-1,i);
            String b = s2.substring(i,i+1);
            int numerA = Integer.parseInt(a);
            int numerB = Integer.parseInt(b);
            if ( numerA% 2 == numerB%2) {
                if (numerA > numerB) {
                    sb2.append(a);
                }else {
                    sb2.append(b);
                }
            }
        }

        if (new String(sb1).equals(new String(sb2))) {
            System.out.println(sb1);
        }else {
            System.out.println(sb1);
            System.out.println(sb2);
        }

    }
}
