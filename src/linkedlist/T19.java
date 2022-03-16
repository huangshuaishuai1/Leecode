package linkedlist;

public class T19 {

    public static void printLinkedlist (ListNode head) {
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = null;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = null;
        printLinkedlist(l1);
        ListNode ret = removeNthFromEnd(l1, 2);
        printLinkedlist(ret);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return head.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;

    }
}
