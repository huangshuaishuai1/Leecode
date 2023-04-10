package niuke;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ty1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(minOperations(s));
    }

    public static int minOperations (String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch,1);
                flag++;
            }else {
                map.put(ch,map.get(ch)+1);
            }
        }
        int count = 0;
        Set<Character> keySet = map.keySet();
        for (Character character : keySet) {
            if (map.get(character) == 1) {
                continue;
            } else  if (map.get(character) == 2) {
                count++;
            } else if (map.get(character) % 2 == 0) {
                int tmp = map.get(character) / 2 - 1;
                int gap = 26 - flag;
                if (gap == 0) {
                    count += map.get(character) - 1;
                }else if (gap >= tmp) {
                    count += (tmp +1);
                    flag += tmp;
                } else {
                    count += gap;
                    flag = 26;
                    count += (map.get(character) - 2 * gap - 1);
                }
            } else {
                int tmp = map.get(character) / 2;
                int gap = 26 - flag;
                if (gap == 0) {
                    count += map.get(character) - 1;
                }else if (gap >= tmp) {
                    count += tmp;
                    flag += tmp;
                } else {
                    count += gap;
                    flag = 26;
                    count += (map.get(character) - 2 * gap - 1);
                }
            }
        }
        return count;
    }
}
