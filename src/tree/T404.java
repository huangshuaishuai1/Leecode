package tree;

import java.util.LinkedList;
import java.util.Queue;

public class T404 {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int s = queue.size();
            while (s>0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    treeNodes.add(poll.left);
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                s--;
            }
        }
        for (TreeNode node:treeNodes) {
            if (node.left == null && node.right==null) {
                sum+=node.val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
