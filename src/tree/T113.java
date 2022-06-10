package tree;

import java.util.LinkedList;
import java.util.List;

public class T113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new LinkedList<>();
            if (root == null) {
                return ret;
            }
            int sum = root.val;
            LinkedList<Integer> nodes = new LinkedList<>();
            nodes.add(root.val);
            backTracking(root,targetSum,nodes,sum,ret);
            return ret;
    }

    public void backTracking(TreeNode node, int targetSum, LinkedList<Integer> nodeList, int sum, List<List<Integer>> ret) {
            if (node.left == null && node.right==null) {
                if (sum == targetSum) {
                    ret.add(new LinkedList<>(nodeList));
                }
            }
            if (node.left!=null) {
                sum+=node.left.val;
                nodeList.add(node.left.val);
                backTracking(node.left,targetSum,nodeList,sum,ret);
                // 回溯
                int back = nodeList.removeLast();
                sum-=back;
            }
            if (node.right!=null) {
                sum+=node.right.val;
                nodeList.add(node.right.val);
                backTracking(node.right,targetSum,nodeList,sum,ret);
                // 回溯
                int back = nodeList.removeLast();
                sum-=back;
            }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(-1);
        TreeNode t4 = new TreeNode(-6);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(-7);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(2);
//        TreeNode t9 = new TreeNode(1);
//        TreeNode t10 = new TreeNode(5);
        root1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t3.right = t5;
        t5.left = t6;

        T113 t113 = new T113();
        List<List<Integer>> lists = t113.pathSum(root1, 0);
        System.out.println(lists);
    }
}
