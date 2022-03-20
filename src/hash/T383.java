package hash;

import java.util.HashMap;

public class T383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] magazine_chars = magazine.toCharArray();
        char[] ransomNote_chars = ransomNote.toCharArray();
        for (int i = 0; i < magazine.length(); i++) {
            if (hashMap.containsKey(magazine_chars[i])) {
                hashMap.put(magazine_chars[i], hashMap.get(magazine_chars[i]) + 1);
            }else {
                hashMap.put(magazine_chars[i], 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!hashMap.containsKey(ransomNote_chars[i]) || hashMap.get(ransomNote_chars[i]) == 0) {
                return false;
            }
            hashMap.put(ransomNote_chars[i], hashMap.get(ransomNote_chars[i]) -1);
        }
        return true;
    }

    public static void main(String[] args) {
        T383 t383 = new T383();
        boolean b = t383.canConstruct("aaab", "aab");
        System.out.println(b);
    }
}
