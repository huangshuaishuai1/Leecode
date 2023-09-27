package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class T94Mid2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return null;
        }
        TreeNode cur = root;
        while(cur!=null || stack.size() != 0) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                cur = pop.right;
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

        T94Mid2 t94Mid2 = new T94Mid2();

        List<Integer> integers = t94Mid2.inorderTraversal(root);
        System.out.println(integers);


    }
}
