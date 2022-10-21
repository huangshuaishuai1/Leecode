package ershua;

public class T206 {
    public ListNode reverseList(ListNode head) {
        ListNode fast = head;
        ListNode slow = null;
        ListNode tmp = null;

        while (fast != null) {
            tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        return slow;
    }

}
