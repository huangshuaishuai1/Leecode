package linkedlist;

public class t_24 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        printLinkedlist(l1);
        ListNode swap = swap(l1);
        printLinkedlist(swap);


    }
    public static ListNode swap(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode scand = first.next;
        first.next = scand.next;
        scand.next = first;
        first = first.next;
        head = scand;
        ListNode tem = scand.next;
        while (first != null && first.next !=null) {
            scand = first.next;
            first.next = scand.next;
            scand.next = first;
            first = first.next;
            tem.next = scand;
            tem = scand.next;
        }

        return head;
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
