package niuke;

import java.util.Scanner;

public class HuaWei3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String number = in.next();
        int ret = 0;

        char[] chars = number.toCharArray();
        for (int i = 2; i < chars.length; i++) {
            int now = 0;
            if (chars[i] =='A') {
                now=10;
            }else if (chars[i]=='B'){
                now=11;
            }else if (chars[i]=='C'){
                now=12;
            }else if (chars[i]=='D'){
                now=13;
            }else if (chars[i]=='E'){
                now=14;
            }else if (chars[i]=='F'){
                now=15;
            }else {
                now = chars[i] - '0';
            }
            ret*=16;
            ret+=now;
        }

        System.out.println(ret);
    }

}
