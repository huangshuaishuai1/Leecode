package ershua;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class T20 {
    public boolean isValid(String s) {

        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                characters.add(c);
            }else {
                Character poll = characters.pop();
                if (c == ')' && poll != '(') {
                    return false;
                }
                if (c == ']' && poll != '[') {
                    return false;
                }
                if (c == '}' && poll != '{') {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

    public static void main(String[] args) {
        T20 t20 = new T20();

        boolean valid = t20.isValid("([");
        System.out.println(valid);

    }
}
