package tree;

import java.util.ArrayDeque;

public class BFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
        bfs(root);
        System.out.println();
        dfs(root);

    }

    private static void dfs(TreeNode root) {
        if (root== null) {
            return;
        }
        System.out.print(root.val);
        System.out.print(" ");
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }

    private static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll.val);
                System.out.print(" ");
                // 将左边的子节点放入队列中
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                // 将右边的子节点放入队列中
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
    }


}
