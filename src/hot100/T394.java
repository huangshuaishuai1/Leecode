package hot100;

import java.util.Stack;

public class T394 {
    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }

    public static String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') {
                StringBuilder tmp = new StringBuilder();
                while(stack.peek() != '[') {
                    tmp.insert(0,stack.pop());
                }
                stack.pop();
                int loop = stack.pop()-'0';
                String str = new String(tmp);
                for(int j = 0; j < loop - 1; j++) {
                    tmp.append(str);
                }
                if(stack.isEmpty()) {
                    ans.append(tmp);
                }else {
                    for(int j = 0; j < tmp.length(); j++) {
                        stack.add(tmp.charAt(j));
                    }
                }
            }
            else if(stack.isEmpty() && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                ans.append(s.charAt(i));
            } else {
                stack.add(s.charAt(i));
            }


        }
        return new String(ans);
    }

}
