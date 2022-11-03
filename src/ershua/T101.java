package ershua;

import java.util.ArrayList;
import java.util.Collections;

public class T101 {

    public boolean isSymmetric(TreeNode root) {
        return hepler(root.left,root.right);
    }

    private boolean hepler(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean leftB = hepler(left.left, right.right);
        boolean rightB = hepler(left.right, right.left);
        return leftB && rightB;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(2);
//        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(2);
//        TreeNode t7 = new TreeNode(3);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
//        t2.right = t5;
        t3.left = t6;
//        t3.right = t7;
        T101 t101 = new T101();
        System.out.println(t101.isSymmetric(root));
    }
}
