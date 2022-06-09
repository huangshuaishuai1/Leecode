package tree;

import java.util.Queue;
import java.util.Stack;

public class T112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        if (root==null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        sum += root.val;
        return backStracking(root,targetSum,sum,stack);
    }
    public boolean backStracking(TreeNode node, int targetSum, int sum, Stack<TreeNode> stack) {
        if (node.left == null && node.right == null) {
            return sum==targetSum;
        }

        boolean L = false, R = false;
        if (node.left != null) {
            sum+=node.left.val;
            stack.push(node.left);
            L = backStracking(node.left, targetSum, sum, stack);
            // 回溯
            TreeNode pop = stack.pop();
            sum -= pop.val;
        }
        if (node.right != null) {
            sum+=node.right.val;
            stack.push(node.right);
            R = backStracking(node.right, targetSum, sum, stack);
            TreeNode pop = stack.pop();
            sum -= pop.val;
        }
        return L || R;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(1);
        root1.left = t2;
        root1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.right = t9;
        T112 t112 = new T112();
        boolean b = t112.hasPathSum(root1, 22);
        System.out.println(b);
    }
}
