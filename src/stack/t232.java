package stack;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 */
public class t232 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public t232() {

    }

    public void push(int x) {
        stack1.push(x);
        int[] ints = new int[stack1.size()];
        stack2.clear();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack1.pop();
            stack2.push(ints[i]);
        }
        for (int i = 0; i < ints.length; i++) {
            stack1.push(ints[ints.length-1-i]);
        }
    }

    public int pop() {
        Integer pop = stack2.pop();
        int[] ints = new int[stack2.size()];
        if (ints.length==0){
            stack1.pop();
        }else {
            stack1.clear();
            for (int i = 0; i < ints.length; i++) {
                ints[i] = stack2.pop();
                stack1.push(ints[i]);
            }
            for (int i = 0; i < ints.length; i++) {
                stack2.push(ints[ints.length-1-i]);
            }
        }
        return pop;
    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty();
    }

    public static void main(String[] args) {
        t232 t232 = new t232();
        t232.push(1);
        t232.push(2);
        System.out.println(t232.peek());
        System.out.println(t232.pop());
        System.out.println(t232.pop());
        System.out.println(t232.empty());
    }
}



