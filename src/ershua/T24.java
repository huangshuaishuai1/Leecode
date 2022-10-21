package ershua;

public class T24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = head.next;
        ListNode tmp = null;
        head = two;
        while (one.next != null && two != null) {
            tmp = two.next;
            two.next = one;
            if (tmp != null) {

                if (tmp.next == null) {
                    one.next = tmp;
                    two = tmp.next;
                }else {
                    one.next = tmp.next;
                    one = tmp;
                    two = tmp.next;
                }
            }else {
                one.next = null;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        T24 t24 = new T24();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
//        node3.next = node4;
        ListNode listNode = t24.swapPairs(head);
        System.out.println(111);
    }
}
