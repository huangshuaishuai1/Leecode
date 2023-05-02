package acwing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baidu1 {
    public static void main(String[] args) {
        Map<Character, Integer> mp = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // 读取换行符
        ArrayList<String> ret = new ArrayList<>();

        while (n-- > 0) {
            String s = scanner.nextLine();
            if (s.length() != 5) {
                ret.add("No");
                continue;
            }
            mp.clear();
            for (char c : s.toCharArray()) {
                mp.put(c, mp.getOrDefault(c, 0) + 1);
            }
            if (mp.containsKey('B') && mp.containsKey('a') && mp.containsKey('i') && mp.containsKey('d') && mp.containsKey('u')) {
                ret.add("Yes");
            } else {
                ret.add("No");
            }
        }
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
        scanner.close();
    }
}
