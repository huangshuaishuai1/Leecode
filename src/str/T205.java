package str;

import java.util.HashMap;

public class T205 {
    public boolean isIsomorhic(String s,String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (map1.containsKey(charS)) {
                if (map1.get(charS) != charT) {
                    return false;
                }
            }else {
                map1.put(charS,charT);
            }
            if (map2.containsKey(charS)) {
                if (map2.get(charS) != charT) {
                    return false;
                }
            }else {
                map2.put(charS,charT);
            }

        }
        return true;
    }
}
