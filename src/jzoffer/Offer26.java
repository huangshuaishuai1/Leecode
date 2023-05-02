package jzoffer;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null) {
            return false;
        }
        LinkedList<Integer> listA = new LinkedList<>();
        LinkedList<Integer> listB = new LinkedList<>();

        helper(listA, A);
        helper(listB, B);

        int lenA = listA.size();
        int lenB = listB.size();

        if(lenB > lenA) {
            return false;
        }

        for (int i = 0; i <= lenA - lenB; i++) {
            int j = 0;
            for (j = 0; j < lenB; j++) {
                if(!listA.get(i+j).equals(listB.get(j))) {
                    break;
                }
            }
            if(j == lenB) {
                return true;
            }
        }
        return false;
    }

    void helper(LinkedList<Integer> list, TreeNode root) {

        if(root.left != null) {
            helper(list, root.left);
        }

        if(root.right != null) {
            helper(list, root.right);
        }

        list.add(root.val);

    }

}
