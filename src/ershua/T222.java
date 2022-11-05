package ershua;

import java.util.LinkedList;
import java.util.Queue;

public class T222 {

    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (! queue.isEmpty()) {
            int size = queue.size();
            while (size > 0 ) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                    count ++;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    count++;
                }
                size--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        T222 t222 = new T222();
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        System.out.println(t222.countNodes(root));
    }
}
