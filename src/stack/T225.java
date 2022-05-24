package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 *
 * 注意：
 *
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 *
 */
public class T225 {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    public T225() {

    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        int times = queue1.size();
        for (int i = 0; i < times - 1; i++) {
            queue2.add(queue1.remove());
        }
        int result = queue1.remove();
        times = queue2.size();
        for (int i = 0; i < times; i++) {
            queue1.add(queue2.remove());
        }
        queue2.clear();
        return result;
    }

    public int top() {
        int times = queue1.size();
        for (int i = 0; i < times - 1; i++) {
            queue2.add(queue1.remove());
        }
        int result = queue1.remove();
        queue2.add(result);
        times = queue2.size();
        for (int i = 0; i < times; i++) {
            queue1.add(queue2.remove());
        }
        return result;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        T225 t225 = new T225();
        t225.push(1);
        t225.push(2);
        System.out.println(t225.pop());
        System.out.println(t225.pop());
        System.out.println(t225.empty());
    }
}
