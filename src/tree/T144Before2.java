package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T144Before2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) {
            return null;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            integers.add(stack.peek().val);
            TreeNode pop = stack.pop();
            if (pop.right!=null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }

        }
        return integers;
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
//        t4.left = t4;
//        t3.right = t7;
//        t4.left=null;
//        t4.right=null;
//        t5.left=null;
//        t5.right=null;
//        t6.left=null;
//        t6.right=null;
//        t7.left=null;
//        t7.right=null;


        T144Before2 t144Before2 = new T144Before2();
        List<Integer> integers = t144Before2.preorderTraversal(root);
        System.out.println(integers);


    }
}
