package tree;

public class T669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return trim(root,low,high);
    }

    private TreeNode trim(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val == high) {
            root.right = null;
            root.left = trim(root.left,low,high);
        }
        else if (root.val == low) {
            root.left = null;
            root.right = trim(root.right,low,high);
        }
        else if (root.val > high) {
            root = trim(root.left,low,high);
        }
        else if (root.val < low) {
            root = trim(root.right,low,high);
        }
        else {
            root.left = trim(root.left,low,high);
            root.right = trim(root.right,low,high);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
//        TreeNode t1 = new TreeNode(0);
//        TreeNode t2 = new TreeNode(4);
//        TreeNode t3 = new TreeNode(2);
//        TreeNode t4 = new TreeNode(1);
//        TreeNode t5 = new TreeNode(4);
//        root.left = t1;
//        root.right = t2;
//        t1.right = t3;
//        t3.left = t4;

        T669 t669 = new T669();
        TreeNode treeNode = t669.trimBST(root, 1, 3);
        System.out.println(treeNode);

    }
}
