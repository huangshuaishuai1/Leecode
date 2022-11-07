package ershua;

public class T404 {

    public int sumOfLeftLeaves(TreeNode root) {
        int ret = helper(root, 0);
        return ret;
    }

    int helper(TreeNode root, int sum) {
        if (root.left != null) {
            if (root.left.left==null&&root.left.right==null) {
                sum+=root.left.val;
            }else {
                sum = helper(root.left,sum);
            }
        }
        if (root.right!=null) {
            sum = helper(root.right,sum);
        }
        return sum;
    }
}
