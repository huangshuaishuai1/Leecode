package wy;

import ershua.ListNode;

import java.util.HashMap;
import java.util.List;

public class TT {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = merge(ans,lists[i]);
        }
        return ans;
    }

    private ListNode merge(ListNode a, ListNode b) {
        if (a == null || b == null) {
            if (a == null) {
                return b;
            }else {
                return a;
            }
        }
        ListNode node1 = new ListNode(0);
        ListNode node2 = node1, pointA = a, pointB = b;
        while (pointA != null && pointB !=null) {
            if (pointA.val < pointB.val) {
                node2.next = pointA;
                pointA = pointA.next;
            } else {
                node2.next = pointB;
                pointB = pointB.next;
            }
            node2 = node2.next;
        }
        if (pointA == null) {
            node2.next = pointB;
        }else {
            node2.next = pointA;
        }
        return node1.next;
    }

    public static void main(String[] args) {
        TT tt = new TT();
    }

//    输入：[1,2,3,1]
//    输出：4
//    解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//    偷窃到的最高金额 = 1 + 3 = 4 。
//    示例 2：
//
//    输入：[2,7,9,3,1]
//    输出：12
//    解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//    偷窃到的最高金额 = 2 + 9 + 1 = 12



}
