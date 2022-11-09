package ershua;

import java.util.ArrayList;
import java.util.List;

public class T131 {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> ret = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        int startIndex = 0;
        helper(s,ret,list,startIndex);
        return ret;
    }

    private void helper(String s, ArrayList<List<String>> ret, ArrayList<String> list, int startIndex) {
        if (startIndex >= s.length()) {
            ret.add(new ArrayList<>(list));
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 判断是否是回文子串
            String substring = s.substring(startIndex, i+1);
            if (isPalindromeString(substring)) {
                list.add(substring);
                helper(s,ret,list,i+1);
                // 回溯
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindromeString(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        T131 t131 = new T131();
        List<List<String>> aba = t131.partition("aab");
        System.out.println(111);

    }
}
