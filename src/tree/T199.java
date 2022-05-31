package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }else {
            return result;
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len>0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right !=null) {
                    queue.add(poll.right);
                }
                len --;
            }
            result.add(list.get(list.size()-1));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(4);
        root.right = t3;
        root.left = t2;
        t2.right = t4;
//        t3.right = t5;
        T199 t199 = new T199();
        List<Integer> integer = t199.rightSideView(root);
        System.out.println(integer);
    }
}
