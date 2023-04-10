package niuke;

public class ty3 {

    public static void main(String[] args) {
        ty3 a = new ty3();
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(1);
        TreeNode t8 = new TreeNode(1);
        root.left = t1;
        root.right = t2;
        t1.left=t3;
        t1.right = t4;
        t2.left =t5;
        t2.right = t6;
        t3.left=t7;
        t3.right=t8;
        System.out.println(a.getTreeSum(root));
    }

    public int getTreeSum (TreeNode tree) {
        // write code here
        int leftSum,rightSum;
        if (tree.left != null) {
            leftSum = getTreeSum(tree.left);
            rightSum = getTreeSum(tree.right);
            return Math.max(leftSum,rightSum) * 2 + 1;
        }
        return 1;
    }
}
