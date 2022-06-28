package tree;

import java.util.LinkedList;

public class T700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        }
        TreeNode treeNode1 = null;
        TreeNode treeNode2 = null;

        if (root.left != null) {
            treeNode1 = searchBST(root.left,val);
        }
        if (root.right != null) {
            treeNode2 = searchBST(root.right, val);
        }
        if (treeNode1 != null) {
            return treeNode1;
        }else {
            return treeNode2;
        }
    }

    public static void main(String[] args) {
        T700 t700 = new T700();
        TreeNode root = new TreeNode(4);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        root.right = t2;
        root.left = t1;
        t1.left = t3;
        t1.right = t4;
        TreeNode treeNode = t700.searchBST(root,2);
        System.out.println(treeNode);
    }
}
