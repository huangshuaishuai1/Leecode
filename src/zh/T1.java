package zh;

import ershua.ListNode;

public class T1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        t1.removeNthFromEnd(listNode,2);

        System.out.println(111);
    }

    public ListNode removeNthFromEnd (ListNode listNode, int n) {
        // write code here

        ListNode pre = listNode;
        ListNode behind = listNode;
        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }

        while (pre.next != null) {
            pre = pre.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return listNode;
    }
}
