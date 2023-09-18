package nenglian;


public class T1 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = null;
        T1 t1 = new T1();
        ListNode partition = t1.partition(listNode, 3);
        System.out.println(111);
    }

    public ListNode partition (ListNode pHead, int x) {
        // write code here
        ListNode dummyLeft = new ListNode(0), dummyRight = new ListNode(0);
        ListNode left = dummyLeft, right = dummyRight;
        while (pHead != null) {
            if (pHead.val < x) {
                left.next = pHead;
                left = left.next;
            } else {
                right.next = pHead;
                right = right.next;
            }
            pHead = pHead.next;
        }
        left.next = dummyRight.next;
        right.next = null;
        return dummyLeft.next;
    }
    public static class ListNode
    { int val;
    ListNode next = null;
    public ListNode(int val) {
    this.val = val;
  }
    }
}
