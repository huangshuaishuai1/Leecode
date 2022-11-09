package ershua;

public class T112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {

            return false;

        }
        return helper(root,targetSum);
    }
    private boolean helper(TreeNode node, int target) {
        int nextTarget = target - node.val;
        if ( node.left == null && node.right == null) {
            if (nextTarget == 0 ) {
                return true;
            }
            else {
                return false;
            }
        }
        boolean left = false;
        boolean right= false;
        if (node.left != null) {
            left = helper(node.left,nextTarget);
        }
        if (node.right != null) {
            right = helper(node.right,nextTarget);
        }
        return  left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        root.left = t1;
        root.right = t2;
        T112 t112 = new T112();
        System.out.println(t112.hasPathSum(root, 5));
    }
}
