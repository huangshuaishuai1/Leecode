package str;

import java.util.ArrayList;
import java.util.HashMap;

public class T1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('c',0);
        map.put('r',1);
        map.put('o',2);
        map.put('a',3);
        map.put('k',4);
        int[] cnt = new int[5];
        int num  =0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            int t = map.get(c);
            if (t == 0) {
                cnt[t] ++;
                num++;
                if (num > ans) {
                    ans = num;
                }
            }else {
                if (cnt[t-1] == 0) {
                    return -1;
                }
                cnt[t-1] --;
                if (t == 4) {
                    num--;
                }else {
                    cnt[t]++;
                }
            }
        }
        if (num > 0) {
            return -1;
        }else {
            return ans;
        }
    }


    public static void main(String[] args) {
        T1419 t1419 = new T1419();
        System.out.println(t1419.minNumberOfFrogs("croakcrook"));
    }
}
