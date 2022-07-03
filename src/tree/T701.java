package tree;

public class T701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        helper(root,val);
        return root;

    }

    private void helper(TreeNode root, int val) {
        if (val > root.val){
            if (root.right != null) {
                helper(root.right, val);
            }else {
                root.right = new TreeNode(val);
            }
        } else {
            if (root.left != null) {

                helper(root.left, val);
            }
            else {
                root.left = new TreeNode(val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        T701 t701 = new T701();
        TreeNode treeNode = t701.insertIntoBST(root, 5);
        System.out.println(treeNode);
    }

}
