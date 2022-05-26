package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class T145After2 {

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            while (stack.peek().left != null) {
                TreeNode node = stack.peek();
                stack.push(node.left);
                node.left = null;
            }
            TreeNode node = stack.peek();
            if (node.right != null) {
                stack.push(node.right);
                node.right = null;
            }else {
                list.add(stack.pop().val);
            }
        }
        return list;
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        root.left = t2;
        root.right = t3;
        root.left = t2;
        t2.left = t4;
        t2.right = t5;
//
        T145After2 t145After2 = new T145After2();
        List<Integer> integers = t145After2.postorderTraversal(root);
        System.out.println(integers);
    }
}
