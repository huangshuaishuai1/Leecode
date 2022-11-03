package ershua;

public class T226 {

    public TreeNode invertTree(TreeNode root) {
        TreeNode temp = new TreeNode();
        temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
