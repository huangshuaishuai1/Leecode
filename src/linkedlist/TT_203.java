package linkedlist;



public class TT_203 {

//    public ListNode removeElements(ListNode head, int val) {
//
//    }

    public static void main(String[] args) {
        //head = [1,2,6,3,4,5,6], val = 6
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
//        l1.next = null;

        printLinkedlist(l1);
        ListNode head = l1;
        while (head.val==6) {
            head = head.next;
            if (head.next == null){
                break;
            }
        }

        ListNode move = head;
        while (move.next != null) {
            while (move.next.val != 6) {
                move = move.next;
                if (move.next == null) {
                    break;
                }
            }
            if (move.next == null) {
                break;
            }
            move.next = move.next.next;
        }
        printLinkedlist(head);
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
