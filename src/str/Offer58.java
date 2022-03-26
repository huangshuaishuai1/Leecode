package str;

import doubelpointer.Offer05;

public class Offer58 {
    public static void main(String[] args) {
        Offer58 offer58 = new Offer58();
        String abcdedg = offer58.reverseLeftWords("ab", 1);
        System.out.println(abcdedg);

    }

    public String reverseLeftWords(String s, int n) {

        char[] temp = new char[n];
        for (int i = 0; i < n; i++) {
            temp[i] = s.charAt(i);
        }

        char[] ret = new char[s.length()];
        for (int i = n; i < s.length(); i++) {
            ret[i - n] = s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            ret[i + s.length() - n] = temp[i];
        }
        return new String(ret);
    }
}
