package niuke;

import java.io.*;
import java.util.Scanner;

public class MeiTuan2021_10_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String st = scanner.readLine();
        int T = Integer.parseInt(st);
        for (int i = 0; i < T; i++) {
            String N = scanner.readLine();
            String strInt = scanner.readLine();
            StringBuilder sb = new StringBuilder(strInt);
            char[] table = strInt.toCharArray();
            String M = scanner.readLine();
            String str = scanner.readLine();
            char[] sex = str.toCharArray();
            for (int j = 0; j < Integer.parseInt(M); j++) {
                int one = sb.indexOf("1");
                int zero = sb.indexOf("0");
                if (sex[j] == 'M') {
                    if ( one != -1) {
                        System.out.println(one+1);
                        sb.replace(one,one+1,"2");
                    }else {
                        System.out.println(zero+1);
                        sb.replace(zero,zero+1,"1");
                    }
                }else {
                    if (zero!=-1) {
                        System.out.println(zero+1);
                        sb.replace(zero,zero+1,"1");
                    }else{
                        System.out.println(one+1);
                        sb.replace(one,one+1,"2");
                    }
                }
            }

        }
    }
}
