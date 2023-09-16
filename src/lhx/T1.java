package lhx;

import java.util.ArrayList;

public class T1 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode node1 = new ListNode(100);
        ListNode node2 = new ListNode(200);
        listNode1.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = null;

        ListNode listNode2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(500);
        listNode2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = null;

        ListNode listNode3 = new ListNode(4);
        ListNode node5 = new ListNode(5000);
        ListNode node6 = new ListNode(50000);
        listNode3.nextNode = node5;
        node5.nextNode = node6;
        node6.nextNode = null;

        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(listNode1);
        listNodes.add(listNode2);
        listNodes.add(listNode3);

//        ListNode node1 = new ListNode(3);
//        ListNode listNode = new ListNode(4);
//        ListNode listNode = new ListNode(1);
//        ListNode listNode = new ListNode(1);
//        ListNode listNode = new ListNode(1);

        ListNode ret = func(3, listNodes);

        System.out.println(111);
    }
    static ListNode func(int k, ArrayList<ListNode> list) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while (list.size() > 0) {
            int minIdx = 0;
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                ListNode listNode = list.get(i);
                if (minVal > listNode.val) {
                    minVal = listNode.val;
                    minIdx = i;
                }
            }
            ListNode listNode = list.get(minIdx);
            list.remove(listNode);
            ListNode tmp = new ListNode(listNode.val);
            head.nextNode = tmp;
            head = head.nextNode;
            listNode = listNode.nextNode;
            if (listNode == null) {
                k--;
            }else {
                list.add(listNode);
            }

        }

        return ans.next();
    }
}

class ListNode {
    int val;
    ListNode nextNode;

    public ListNode(int val) {
        this.val = val;
        this.nextNode = null;
    }

    public ListNode next() {
        return this.nextNode;
    }
}
