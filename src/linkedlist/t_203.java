package linkedlist;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class t_203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node1.val == val && node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        head = node1;
        while (node1.next != null && node2.next != null) {
            while (node2.val != val && node2.next != null) {
                node1 = node2;
                node2 = node2.next;
            }
            while(node2.val == val && node2.next != null) {
                node2 = node2.next;
                node1.next = node2;
            }

        }
        if (node1.val == val){
            return null;
        }
        else if (node2 != null && node2.val == val) {
            node1.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
//        ListNode node2 = new ListNode(7);
//        ListNode node3 = new ListNode(7);
//        ListNode node4 = new ListNode(7);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(5);
//        ListNode node7 = new ListNode(6);
        head.next = null;
//        node2.next = node3;
//        node3.next = node4;

//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = null;
//        ListNode head = null;
        printLinkedlist(head);
        t_203 f = new t_203();
        ListNode results = f.removeElements(head, 8);
        printLinkedlist(results);

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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
