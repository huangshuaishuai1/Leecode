package dp;

import java.util.ArrayList;
import java.util.List;

public class T22 {

    public List<String> generateParenthesis(int n) {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        ArrayList<String> one = new ArrayList<>();
        one.add("()");
        arrayLists.add(one);
        for (int i = 1; i < n; i++) {
            ArrayList<String> now = new ArrayList<>();
            ArrayList<String> tmp = arrayLists.get(i - 1);
            for (String s : tmp) {
                for (int j = 0; j < s.length(); j++) {
                    StringBuilder loop = new StringBuilder(s);
                    StringBuilder insert = loop.insert(j, "()");
                    String s1 = new String(insert);
                    if (!now.contains(s1)) {
                        now.add(s1);
                    }
                }
                if (!now.contains(s+"()")) {
                    now.add(new String(s+"()"));
                }
            }
            arrayLists.add(new ArrayList<>(now));
        }
        return arrayLists.get(n-1);
    }

    public static void main(String[] args) {
        T22 t22 = new T22();
        List<String> strings = t22.generateParenthesis(3);
        System.out.println(
                111
        );
    }
}
