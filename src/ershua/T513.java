package ershua;

import java.util.LinkedList;
import java.util.Queue;

public class T513 {

    public int findBottomLeftValue(TreeNode root) {
        // 层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ret = 0;
        while (!queue.isEmpty()) {
            ret = queue.peek().val;
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
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

}
