package ershua;

public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode tmp1 = tmp;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            tmp = tmp.next;
            fast = fast.next;
        }
        tmp.next = tmp.next.next;
        return tmp1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);

        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        T19 t19 = new T19();
        ListNode listNode = t19.removeNthFromEnd(head, 2);
        System.out.println(111);

    }
}
