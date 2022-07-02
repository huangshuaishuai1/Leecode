package tree;

public class T235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        int max = Math.max(pVal, qVal);
        int min = Math.min(pVal, qVal);
        if ( max < rootVal) {
            return lowestCommonAncestor(root.left,p,q);
        }else if (min > rootVal) {
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }


}
