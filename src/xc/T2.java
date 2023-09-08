package xc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] chars = new char[n][m];
        HashMap<Integer, HashMap<Integer, HashMap<Character, Integer>>> rows = new HashMap<>();
        HashMap<Integer, HashMap<Character, Integer>> col = new HashMap<>();
        for (int i = 0; i <n; i++) {
            HashMap<Integer, HashMap<Character, Integer>> row = rows.getOrDefault(i, new HashMap<>());
            String str = scanner.next();
            for (int j = 0; j < m; j++) {
                chars[i][j] = str.charAt(j);
                if (chars[i][j] == 'y' || chars[i][j] == 'o' || chars[i][j] == 'u') {
                    HashMap<Character, Integer> map1 = new HashMap<>();
                    if (j > 0) {
                        HashMap<Character, Integer> map = row.get(j-1);

                        map1.put('y',map.getOrDefault('y', 0));
                        map1.put('o',map.getOrDefault('o', 0));
                        map1.put('u',map.getOrDefault('u', 0));
                        Integer integer = map1.getOrDefault(chars[i][j], 0);
                        integer++;
                        map1.put(chars[i][j],integer);
                    }else {

                        map1.put(chars[i][j],1);
                    }
                    row.put(j,map1);
                }
            }
            rows.put(i,row);
        }
        HashSet<Character> set = new HashSet<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!(chars[i][j] == 'y' || chars[i][j] == 'o' || chars[i][j] == 'u')) {
                    continue;
                }
                set.add(chars[i][j]);
                for (int k = i+1; k < n; k++) {
                    if (!(chars[k][j] == 'y' || chars[k][j] == 'o' || chars[k][j] == 'u') || set.contains(chars[k][j])) {
                        continue;
                    }
                    set.add(chars[k][j]);
                    char tmp;
                    if (!set.contains('y')) {
                        tmp = 'y';
                    }else if (!set.contains('o')){
                        tmp = 'o';
                    }else {
                        tmp = 'u';
                    }
                    ans += rows.get(i).get(m-1).getOrDefault(tmp,0) - rows.get(i).get(k).getOrDefault(tmp,0);
                    set.remove(chars[k][j]);
                }
                set.remove(chars[i][j]);
            }
        }
        System.out.println(ans);
    }
}
