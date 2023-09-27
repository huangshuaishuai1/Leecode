package hot100;

import java.util.HashMap;
import java.util.Set;

public class T76 {
    static HashMap<Character, Integer> count = new HashMap<>();
    static HashMap<Character, Integer> ret = new HashMap<>();
    public String minWindow(String s, String t) {

        int lenT = t.length();
        for(int i = 0; i < lenT; i++) {
            int tmp = count.getOrDefault(t.charAt(i),0);
            count.put(t.charAt(i),tmp+1);
        }

        int left = 0, right = -1, lenS = s.length(), ans = Integer.MAX_VALUE, ansL = -1, ansR = -1, size = 0;
        while(right < lenS) {
            right ++;
            size++;
            if(right < lenS && count.containsKey(s.charAt(right))) {
                ret.put(s.charAt(right), ret.getOrDefault(s.charAt(right),0)+1);
            }
            while(check() && left <= right) {
                if(size < ans) {
                    ans = size;
                    ansL = left;
                    ansR = right;
                }
                if(count.containsKey(s.charAt(left))) {
                    ret.put(s.charAt(left), ret.getOrDefault(s.charAt(left),0)-1);
                }
                left++;
                size--;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR+1);
    }

    static boolean check() {
        Set<Character> set = count.keySet();
        for(Character c : set) {
            if(count.get(c) > ret.getOrDefault(c,0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T76 t76 = new T76();
        System.out.println(t76.minWindow("a", "a"));
    }
}
