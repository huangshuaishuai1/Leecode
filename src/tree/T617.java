package tree;

public class T617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root2==null) {
            return root1;
        } else if (root1 == null) {
            return root2;
        } else {
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);

        root1.left = t1;
        root1.right = t2;
        t1.left = t3;

        root2.left = t4;
        root2.right = t5;
        t4.right = t6;
        t5.right = t7;
        T617 t617 = new T617();
        TreeNode treeNode = t617.mergeTrees(root1, root2);
        System.out.println(treeNode);


    }

}
