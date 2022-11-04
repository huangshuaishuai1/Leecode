package ershua;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        int level = 0;
        while (queue1.size() != 0 || queue2.size() != 0) {
            if (queue1.size() != 0) {
                level++;
                while (queue1.size()!=0) {
                    TreeNode poll = queue1.poll();
                    if (poll.left!=null) {
                        queue2.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue2.add(poll.right);
                    }
                }
            }
            else if (queue2.size() != 0) {
                level ++;
                while (queue2.size() != 0) {
                    TreeNode poll = queue2.poll();
                    if (poll.left != null) {
                        queue1.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue1.add(poll.right);
                    }
                }
            }
        }
        return level;
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
        T104 t104 = new T104();
        System.out.println(t104.maxDepth(root));

    }
}
