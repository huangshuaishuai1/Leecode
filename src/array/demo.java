package array;


import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        String str = (3174.0/1419211.0)*100+"";
        int i = str.indexOf('.');
        System.out.println(str);
        System.out.println(str.substring(0,i+3));

    }


}

