package linkedlist;

public class TT876 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        System.out.println(middleNode(listNode).val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null && fast != null) {

            if(fast.next == null) {
                return slow;
            }
            if(fast.next.next == null) {
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
