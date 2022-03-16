package linkedlist;

public class T0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        int a_nums = 1;
        int b_nums = 1;


        while (a.next!= null) {
            a = a.next;
            a_nums++;
        }

        while (b.next!=null) {
            b = b.next;
            b_nums++;
        }

        a = headA;
        b = headB;
        if (a_nums > b_nums) {
            for (int i = 0; i < a_nums-b_nums; i++) {
                b = b.next;
            }
        }else {
            for (int i = 0; i < b_nums - a_nums; i++) {
                a = a.next;
            }
        }

        while (a.next !=null && b.next != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        if (a == b) {
            return  a;
        }

        return null;

    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);

        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        c1.next = c2;
        c2.next = c3;
        c3.next = null;
        printLinkedlist(a1);
        printLinkedlist(b1);
        T0207 t0207 = new T0207();
        ListNode res = t0207.getIntersectionNode(a1, b1);
        printLinkedlist(res);



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
