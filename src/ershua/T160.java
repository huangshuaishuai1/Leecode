package ershua;

public class T160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        int b = 0;
        ListNode A = headA;
        ListNode B = headB;
        while (A != null) {
            A = A.next;
            a ++;
        }
        while (B != null) {
            B = B.next;
            b++;
        }
        A = headA;
        B = headB;
        if (a > b) {
            for (int i = 0; i < a - b; i++) {
                A = A.next;
            }
        }else {
            for (int i = 0; i < b - a; i++) {
                B = B.next;
            }
        }

        ListNode ret = null;
        while (A != null) {
            if (A.val == B.val) {
                ret = A;
            }
        }
        return ret;
    }



}
