package linkedlist;

import java.util.List;

public class T_206_no_stack {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = null;
        printLinkedlist(l1);
        ListNode pre = null;
        ListNode cur = l1;
        ListNode tem = cur.next;
        while (tem != null) {
            cur.next = pre;
            pre = cur;
            cur = tem;
            tem = tem.next;
        }
        cur.next = pre;
        printLinkedlist(cur);
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
