package ershua;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class demo2 {
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
        pre(root);
        System.out.println("--------------");
        // 中序
        mid(root);
        System.out.println("--------------");
        //层次
        level(root);
    }

    private static void level(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    private static void pre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.pop();
            System.out.println(peek.val);
           if (peek.right != null) {
               stack.add(peek.right);
           }
           if (peek.left!=null) {
               stack.add(peek.left);
           }
        }
    }

    private static void mid(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = new TreeNode();
        if (root == null) {
            return;
        }
        temp = root;
        stack.add(root);
        while (temp != null && !stack.isEmpty()) {
            if (temp.left != null) {
                stack.add(temp.left);  // 左边
                temp = temp.left;
            }else {
                TreeNode top = stack.pop(); // 中间
                System.out.println(top.val);
                if (top.right != null) {
                    stack.add(top.right);  // 右边
                    temp = top.right;
                }
            }
        }
    }


}
