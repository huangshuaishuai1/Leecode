package str;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class T459 {
    public boolean repeatedSubstringPattern(String s) {
       int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 1; i <= len / 2; i++) { // i 代表目标字符串的长度
           if (len % i != 0) {
                continue;
           }
           // 拿到候选目标字串
            char[] chars1 = new char[i];
            for (int j = 0; j < i; j++) {
                chars1[j] = chars[j];
            }
            int times = len / i;
            int j = 0;
            for (j  = 0; j < times - 1; j++) {
                int k = 0;
                for (k = 0; k < i; k++) {
                    if (chars[(j+1)*i + k] != chars1[k] ) {
                        break;
                    }
                }
                if (k != i) break;
            }
            if (j == times -1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        T459 t459 = new T459();
        boolean abab = t459.repeatedSubstringPattern("aa");
        System.out.println(abab);
    }
}
