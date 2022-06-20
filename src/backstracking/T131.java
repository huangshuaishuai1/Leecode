package backstracking;

import tree.T113;

import java.util.LinkedList;
import java.util.List;

public class T131 {

    public List<List<String>> partition(String s) {
        LinkedList<List<String>> ret = new LinkedList<>();
        LinkedList<String> strings = new LinkedList<>();
        backStraking(s, ret, strings, 0);
        return ret;
    }

    public void backStraking(String s,LinkedList<List<String>> ret, LinkedList<String> stings, int cutIndex) {
        if (cutIndex == s.length()) {
            ret.add(new LinkedList<>(stings));
            return;
        }

        for (int i = cutIndex; i < s.length(); i++) {
            if (isPar(s.substring(cutIndex,i+1))) {
                stings.add(s.substring(cutIndex,i+1));
            }else {
                continue;
            }
            backStraking(s,ret,stings,i+1);
            // 回溯
            stings.removeLast();
        }


    }
    public boolean isPar(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T131 t131 = new T131();
        List<List<String>> aba = t131.partition("ababa");

        System.out.println(aba);
    }

}
