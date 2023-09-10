package dxm;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String strings = sc.next();
        helper(strings,k);
    }
    public static void helper(String str, int k) {
        int numberA = 0;
        long ans = 0;
        long count = 0;
        for(char ch:str.toCharArray()) {
            if (ch=='A') {
                numberA++;
            }
        }
        while (k>numberA) {
            ans+=str.length();
            k-=numberA;
        }

        for (int i = 0; i < str.length(); i%=str.length()) {
            if (str.charAt(i) == 'A') {
                count++;
            }
            ans++;
            if (count == k) {
                break;
            }
            i++;
        }
        System.out.println(ans);
    }
}
