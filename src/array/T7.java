package array;

import java.util.Arrays;

public class T7 {

    public int reverse(int x) {
        String s = null;
        if (x < 0) {
            String s1 = String.valueOf(x);
            s = s1.substring(1);
        }else {
            s = String.valueOf(x);
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length/2; i++) {
            char a = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length-1 -i] = a;
        }
        String ansStr = new String(charArray);
        Long ans = Long.valueOf(ansStr);
        if (ans > Integer.MAX_VALUE) {

        }
        if (x < 0) {
            return ans * (-1);
        }else {
            return ans;
        }
    }

    public static void main(String[] args) {
        T7 t7 = new T7();
        System.out.println(t7.reverse(1534236469));
    }
}
