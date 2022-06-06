package tree;

import java.util.LinkedList;
import java.util.Queue;

public class T110 {
    public boolean isBalanced(TreeNode root) {
        // 计算左子树的深度
        int left = helper(root.left);
        // 计算右子树深度
        int right = helper(root.right);
        if(Math.abs(left-right) > 1) {
            return false;
        }
        // 递归到左子树的子树
        if(left != 0) {
            boolean bLeft = isBalanced(root.left);
            if (!bLeft) {
                return bLeft;
            }
        }
        if (right != 0) {
            boolean bRight = isBalanced(root.right);
            if (!bRight) {
                return bRight;
            }
        }

        return true;
    }
    public int helper(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(node == null) {
            return 0;
        }
        int ret = 0;
        queue.add(node);
        while(!queue.isEmpty()) {
            ret++;
            int size = queue.size();
            while(size>0) {
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(15);
//        TreeNode t5 = new TreeNode(7);
        root.right = t2;
//        root.left = t2;
//        t3.left = t4;
        t2.right = t3;
        T110 t110 = new T110();
        System.out.println(t110.isBalanced(root));

    }
}
