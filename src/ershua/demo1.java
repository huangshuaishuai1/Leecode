package ershua;

import sun.awt.windows.WPrinterJob;

public class demo1 {
    // 先序
    private static void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }
    //中序
    private static void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        System.out.println(root.val);
        mid(root.right);
    }
    // 二叉树的递归遍历
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        // 前序
//        pre(root);
        // 中序
//        mid(root);
        // 后序
        behind(root);
    }

    private static void behind(TreeNode root) {
        if (root == null) {
            return;
        }
        behind(root.left);
        behind(root.right);
        System.out.println(root.val);
    }
}
