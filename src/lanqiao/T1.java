package lanqiao;

import java.util.HashMap;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        char ret = 'a'+100;
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (map.containsKey(tmp)) {
                Integer numer = map.get(tmp);
                map.put(tmp,numer+1);
                if (numer+1 >= max) {
                    if (numer+1 > max || (numer+1 == max && tmp < ret)) {
                        ret = tmp;
                    }
                    max = numer+1;
                }
            }else {
                map.put(tmp,1);
                if (max == 0 || (max == 1 && tmp < ret)) {
                    ret=tmp;
                    if (max == 0) {
                        max = 1;
                    }
                }
            }
        }
        System.out.println(ret);
        System.out.println(max);
    }

}
