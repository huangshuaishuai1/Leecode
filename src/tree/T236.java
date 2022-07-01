package tree;

import java.util.LinkedList;

public class T236 {
    LinkedList<Integer> mid = new LinkedList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        midOrder(root);
        return helper(root,p,q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        int indexOfRoot = mid.indexOf(root.val);
        int indexOfP = mid.indexOf(p.val);
        int indexOfQ = mid.indexOf(q.val);

        if ((indexOfP <= indexOfRoot && indexOfQ >= indexOfRoot) || (indexOfQ <= indexOfRoot && indexOfP >= indexOfRoot)) {
            return root;
        }else if (indexOfP < indexOfRoot ){
            return helper(root.left, p, q);
        }else{
            return helper(root.right, p, q);
        }
    }

    void midOrder(TreeNode root) {
        if (root.left != null) {
            midOrder(root.left);
        }
        mid.add(root.val);
        if (root.right != null) {
            midOrder(root.right);
        }
    }
}
