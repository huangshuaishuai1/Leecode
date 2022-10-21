package ershua;



public class T203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null&&head.val == val) {
            head = head.next;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null) {
            fast = slow.next;
            while (fast!=null && fast.val == val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        T203 t203 = new T203();
        ListNode listNode = t203.removeElements(node1, 1);
        System.out.println(111);

    }
}
