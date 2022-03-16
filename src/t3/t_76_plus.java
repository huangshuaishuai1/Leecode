package t3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class t_76_plus {
    HashMap<Character, Integer> hashs = new HashMap<Character, Integer>();
    HashMap<Character, Integer> hasht = new HashMap<Character, Integer>();
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            hasht.put(t.charAt(i), hasht.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = -1;
        int len = Integer.MAX_VALUE, anL = -1, anR = -1;
        while (right < s.length()) {
            ++ right;
            if (right < s.length() && hasht.containsKey(s.charAt(right))) {
                hashs.put(s.charAt(right), hashs.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
//                result = len < anR - anL + 1 ? result : s.substring(anL, anR);
                if (right - left + 1 <len) {

                    len = right - left + 1;
                    anL = left;
                    anR = left + len;
                }
                if (hasht.containsKey(s.charAt(left))) {
                    hashs.put(s.charAt(left), hashs.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return anL == -1 ? "" : s.substring(anL, anR);
//        return result;
    }

    public boolean check() {
        Iterator iterator = hasht.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Character c = (Character) entry.getKey();
            Integer i = (Integer) entry.getValue();
            if (hashs.getOrDefault(c, 0) < i) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        t_76_plus f = new t_76_plus();
//        String result = f.minWindow("ADOBECODEBANC", "ABC");
        String result = f.minWindow("a", "aa");
        System.out.println(result);

    }
}
