package ershua;

import java.util.HashMap;
import java.util.Set;

public class T383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int i  = 0;
        for (i = 0; i < ransomNote.length(); i++) {
            if (!map1.containsKey(ransomNote.charAt(i))){
                map1.put(ransomNote.charAt(i),1);
            }else {
                map1.put(ransomNote.charAt(i),map1.get(ransomNote.charAt(i))+1);
                if (map1.get(ransomNote.charAt(i)) == 0) {
                    map1.remove(ransomNote.charAt(i));
                }
            }

            if (!map2.containsKey(magazine.charAt(i))){
                map2.put(magazine.charAt(i),1);
            }else {
                map2.put(magazine.charAt(i),map2.get(magazine.charAt(i))+1);
            }
        }
        for (; i < magazine.length(); i++) {
            if (!map2.containsKey(magazine.charAt(i))){
                map2.put(magazine.charAt(i),1);
            }else {
                map2.put(magazine.charAt(i),map2.get(magazine.charAt(i))+1);
            }
        }
        Set<Character> keys = map1.keySet();
        for (Character key :
                keys) {
            Integer tmp = map1.get(key);
            if (map2.containsKey(key)) {
                if (map2.get(key) < tmp) {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T383 t383 = new T383();
        System.out.println(t383.canConstruct("aa", "ab"));
    }
}
