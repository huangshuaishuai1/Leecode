package stack;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括+、-、*、。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 注意两个整数之间的除法只保留整数部分。
 *
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class T150 {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int ret = 0;
        int tag = 0;
        if (tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i]) ||"-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])){
                int behind= 0;
                int front = 0;

                behind = Integer.parseInt(stack.pop());
                front = Integer.parseInt(stack.pop());



                if ("+".equals(tokens[i])){
                    ret = front + behind;
                }else if ("-".equals(tokens[i])){
                    ret = front - behind;
                }else if ("*".equals(tokens[i])){
                    ret = front*behind;
                }else {
                    ret = front/behind;
                }
                stack.push(String.valueOf(ret));
            }
            else{

                stack.push(tokens[i]);
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        T150 t150 = new T150();
        int i = t150.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println(i);
    }
}
