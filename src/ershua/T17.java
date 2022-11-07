package ershua;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class T17 {

    public List<String> letterCombinations(String digits) {
        ArrayList<String> ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<String> keyboard = new ArrayList<>();
        keyboard.add("abc");
        keyboard.add("def");
        keyboard.add("ghi");
        keyboard.add("jkl");
        keyboard.add("mno");
        keyboard.add("pqrs");
        keyboard.add("tuv");
        keyboard.add("wxyz");
        char[] chars = digits.toCharArray();
        int startIndex = 0;
        helper(startIndex,chars,ret,characters,keyboard);
        return ret;
    }

    private void helper(int startIndex, char[] chars, ArrayList<String> ret, ArrayList<Character> characters, ArrayList<String> keyboard) {
        if (characters.size() == chars.length) {
            StringBuilder sb = new StringBuilder();
            characters.stream()
                    .forEach(new Consumer<Character>() {
                        @Override
                        public void accept(Character character) {
                            sb.insert(sb.length(),character);
                        }
                    });
            ret.add(new String(sb));
        }
        for (int i = startIndex; i < chars.length; i++) {
            String s = keyboard.get(Integer.valueOf(chars[i] - 48) - 2);
            for (int j = 0; j < s.length(); j++) {
                characters.add(s.charAt(j));
                helper(i+1,chars,ret,characters,keyboard);
                // 回溯
                characters.remove(characters.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        T17 t17 = new T17();
        List<String> strings = t17.letterCombinations("23");
        System.out.println(111);
    }
}
