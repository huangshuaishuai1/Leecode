package ershua;

import java.util.Stack;

public class T1047 {

    public String removeDuplicates(String s) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!characters.isEmpty() && c == characters.peek()) {
                characters.pop();
            }else {
                characters.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = characters.size();
        for (int i = 0; i < size; i++) {
            Character pop = characters.pop();
            sb.insert(0,pop);
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        T1047 t1047 = new T1047();
        System.out.println(t1047.removeDuplicates("abbaca"));
    }
}
