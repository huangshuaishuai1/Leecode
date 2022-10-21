package ershua;

import java.util.HashMap;
import java.util.Set;

public class T242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            }else {
                hashMap.put(s.charAt(i),1);
            }
            if (hashMap.containsKey(t.charAt(i))) {
                hashMap.put(t.charAt(i),hashMap.get(t.charAt(i)) - 1);
            }else {
                hashMap.put(t.charAt(i),-1);
            }
            if (hashMap.containsKey(s.charAt(i)) && hashMap.get(s.charAt(i)) == 0) {
                hashMap.remove(s.charAt(i));
            }
            if (hashMap.containsKey(t.charAt(i)) && hashMap.get(t.charAt(i)) == 0) {
                hashMap.remove(t.charAt(i));
            }
        }

        return hashMap.isEmpty();
    }

    public static void main(String[] args) {
        T242 t242 = new T242();
        System.out.println(t242.isAnagram("anagram", "nagaram"));
    }
}
