package dp;

import java.util.ArrayList;

public class T337 {
    public int rob(TreeNode root) {
        int[] ret = helper(root);
        return Math.max(ret[0],ret[1]);
    }

    private int[] helper(TreeNode root) {
        int[] ret = new int[2];
        if(root == null) {
            return ret;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        ret[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        ret[1] = left[0] + right[0] + root.val;
        return ret;
    }


    public static void main(String[] args) {
        T337 t337 = new T337();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
//        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(t337.rob(root));
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
