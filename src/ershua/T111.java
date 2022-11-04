package ershua;

import java.util.LinkedList;
import java.util.Queue;

public class T111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ret = 0;
        while (!queue.isEmpty()) {
            ret ++;
            int size = queue.size();
            while (size > 0 ) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return ret;
                }
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
                size--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        T111 t111 = new T111();
        System.out.println(t111.minDepth(root));
    }
}
