package tree;

import java.util.LinkedList;
import java.util.Queue;

public class T513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int ret = root.val;
        queue.add(root);
        while(!queue.isEmpty()) {
            ret = queue.peek().val;
            int size = queue.size();
            while(size > 0) {
                TreeNode poll = queue.poll();
                if(poll.left!=null) {
                    queue.add(poll.left);
                }
                if(poll.right!=null) {
                    queue.add(poll.right);
                }

                size --;
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        T513 t513 = new T513();
        root1.left = t2;
        root1.right = t3;
        int bottomLeftValue = t513.findBottomLeftValue(root1);
        System.out.println(bottomLeftValue);
    }
}
