package linkedlist;

public class funplusT2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        listNode.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        funplusT2 funplusT2 = new funplusT2();
        funplusT2.reverseBetween(listNode,2,4);
    }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode m_1 = head;
        ListNode pre = head;
        ListNode pre2 = head;
        for (int i = 0; i < n-1; i++) {
            if (i < m-2) {
                m_1 = m_1.next;
            }
            if (i < m-1) {
                pre = pre.next;
            }
            pre2 = pre2.next;
        }
        m_1.next = pre2;
        ListNode current = pre.next;
        pre.next = pre2.next;

        int loop = n-m;

        ListNode next = current.next;

        while (loop > 0) {
            current.next = pre;
            pre = current;
            current = next;
            next = next.next;
            loop--;
        }
        return head;
    }
}
