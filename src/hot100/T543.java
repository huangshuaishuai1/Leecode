package hot100;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        int max = Math.max(Math.max(lDepth+rDepth,diameterOfBinaryTree(root.left)),diameterOfBinaryTree(root.right));
        return max;
    }

    static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(queue.size()!=0){
            int sz = queue.size();
            ans++;
            for(int i = 0; i < sz; i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null) {
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
        }
        return ans;
    }
}
