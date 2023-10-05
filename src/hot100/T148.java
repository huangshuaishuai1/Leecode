package hot100;

import ershua.ListNode;

public class T148 {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode listNode = sortList(node);
        System.out.println(11);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }
        // 将这个head分成两个两个的组合
        return split(head);
        // 将局部有序的链表合并成全局有序

    }

    static ListNode split(ListNode node) {
        if(node.next == null) {
            return node;
        }
        if(node.next.next == null) {
            ListNode tmp = node;
            tmp = tmp.next;
            if(tmp.val < node.val) {
                tmp.next = node;
                node.next = null;
                return tmp;
            }
            return node;
        }
        ListNode fast = node;
        ListNode slow = node;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null && fast.next != null) {
                slow = slow.next;
            }

        }
        fast = slow.next;
        slow.next = null;
        return sortSplit(split(node),split(fast));
    }

    static ListNode sortSplit(ListNode slow, ListNode fast) {
        ListNode dummyNode = new ListNode(0);
        ListNode moved = dummyNode;
        while(slow != null && fast != null) {
            int s = slow.val;
            int f = fast.val;
            if(s < f) {
                moved.next = slow;
                moved = moved.next;
                slow = slow.next;
            }else {
                moved.next = fast;
                moved = moved.next;
                fast = fast.next;
            }
        }
        if(fast == null && slow == null) {
            return dummyNode.next;
        }
        if(fast!=null) {
            moved.next = fast;
        }else {
            moved.next = slow;
        }
        return dummyNode.next;
    }

}
