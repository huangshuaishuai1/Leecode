package linkedlist;

import java.util.HashMap;

public class T142 {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> hashMap = new HashMap<>();
        while (head.next != null) {
            if (hashMap.containsKey(head)) {
                return head;
            }else {
                hashMap.put(head, 1);
            }
            head = head.next;
        }
        return null;

    }

}
