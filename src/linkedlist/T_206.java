package linkedlist;
import java.util.Stack;

public class T_206 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = null;
        printLinkedlist(l1);
        Stack<Integer> stack = new Stack<>();
        ListNode head = l1;
        while (head.next != null) {
            stack.push(head.val);
            head = head.next;
        }
        stack.push(head.val);
        head = l1;
        while (!stack.isEmpty()){
            head.val = stack.pop();
            head = head.next;
        }
        printLinkedlist(l1);

    }

    public static void printLinkedlist (ListNode head) {
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }
}
