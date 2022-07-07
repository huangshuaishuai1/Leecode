package tree;


import java.util.ArrayList;

public class T538 {
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        ArrayList<Integer> mid = new ArrayList<>();
        midSort(mid,root);

        ArrayList<Integer> newTree = new ArrayList<>();
        int count = 0;
        for (int i = mid.size()-1; i >=0 ; i--) {
            count+=mid.get(i);
            newTree.add(0,count);
        }
        return generator(mid,root,newTree);
    }

    private TreeNode generator(ArrayList<Integer> mid, TreeNode root, ArrayList<Integer> newTree) {
        if (root == null) {
            return null;
        }
        TreeNode treeNode = null;
        for (int i = 0; i < mid.size(); i++) {
            if (mid.get(i) == root.val) {
                treeNode = new TreeNode(newTree.get(i));
            }
        }
        treeNode.left = generator(mid,root.left,newTree);
        treeNode.right = generator(mid,root.right,newTree);
        return treeNode;
    }

    // 中序遍历
    private void midSort (ArrayList<Integer> mid, TreeNode root) {
        if (root.left != null) {
            midSort(mid,root.left);
        }
        mid.add(root.val);
        if (root.right != null) {
            midSort(mid,root.right);
        }
    }
}
