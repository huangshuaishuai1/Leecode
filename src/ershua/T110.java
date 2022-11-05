package ershua;

import java.util.LinkedList;
import java.util.Queue;

public class T110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftLevel = 0;
        if (root.left!=null) {leftLevel = level(root.left);}
        int rightLevel = 0;
        if (root.right!=null) {rightLevel = level(root.right);}
        return Math.abs(leftLevel - rightLevel) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int level(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0 ;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level ++ ;
            while (size > 0 ) {
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
        }
        return level;
    }
    // 层次遍历
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        root.left = t2;
        root.right = t3;
        t3.left = t4;
        t3.right = t5;
        T110 t110 = new T110();
        System.out.println(t110.isBalanced(root));
    }

}
