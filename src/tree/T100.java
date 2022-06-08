package tree;

public class T100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p,q);
    }
    boolean compare(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        boolean compareL = compare(node1.left, node2.left);
        boolean compareR = compare(node1.right, node2.right);
        return compareL && compareR;

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//
//        root1.left = t2;
//        root1.right = t3;
//        t2.left = t4;
//
//        root2.left = t4;
//        root2.right = t3;

        T100 t100 = new T100();
        boolean sameTree = t100.isSameTree(root1, root2);
        System.out.println(sameTree);

    }
}
