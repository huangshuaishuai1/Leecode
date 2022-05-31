package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T637 {
    public List<Double> averageOfLevels(TreeNode root) {

        ArrayList<Double> doubles = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }else {
            return doubles;
        }

        while (!queue.isEmpty()) {
            Double item = 0.0;
            int len = queue.size();
            int len2 = len;
            while (len >0 ){
                TreeNode poll = queue.poll();
                item += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                len --;
            }
            doubles.add(item/len2);
        }
        return doubles;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        root.right = t3;
        root.left = t2;
        t3.left = t4;
        t3.right = t5;
        T637 t637 = new T637();
        List<Double> integers = t637.averageOfLevels(root);
        System.out.println(integers);

    }

}
