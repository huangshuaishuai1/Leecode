package tree;

public class funplusT1 {
    static int count  = 0;
    public static void main(String[] args) {
        funplusT1 funplusT1 = new funplusT1();
        TreeNode treeNode = new TreeNode(1);
        TreeNode one = new TreeNode(2);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(4);
        TreeNode four = new TreeNode(5);
        TreeNode five = new TreeNode(6);
        treeNode.left = one;
        treeNode.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        funplusT1.sumOfLeftLeaves(treeNode);
        System.out.println(count);
    }

    public int sumOfLeftLeaves (TreeNode root) {
        // write code here
        if (root.left != null) {
            helper(root.left,0);
        }
        if (root.right != null) {
            helper(root.right, 1);
        }

        return count;
    }

    static void helper(TreeNode node, int tag) {
        if (node.left == null && node.right == null) {
            if (tag == 0) {
                count += node.val;
            }
            return ;
        }
        if (node.left != null) {
            helper(node.left,0);
        }
        if (node.right != null) {
            helper(node.right, 1);
        }

    }


}
