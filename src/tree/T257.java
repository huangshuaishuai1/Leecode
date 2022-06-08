package tree;

import java.util.LinkedList;
import java.util.List;

public class T257 {

    LinkedList<String> ret = new LinkedList<>();
    LinkedList<Integer> vlues = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return ret;
        }
        helper(root);
        return ret;
    }

    public void helper(TreeNode node){
        vlues.add(node.val);
        if (node.left == null && node.right ==null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(vlues.get(0));
            for (int i = 1; i < vlues.size(); i++) {
                stringBuilder.append("->");
                stringBuilder.append(vlues.get(i));
            }
            ret.add(new String(stringBuilder));
            return;
        }
        if (node.left != null) {
            helper(node.left);
            vlues.removeLast();
        }
        if (node.right != null) {
            helper(node.right);
            vlues.removeLast();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);

//        TreeNode t5 = new TreeNode(7);
        root.left = t2;
        root.right = t3;
//        t3.left = t4;
        t2.right = t4;
        t2.left = t5;
        t5.right = t6;
        T257 t257 = new T257();
        List<String> strings = t257.binaryTreePaths(root);
        System.out.println(strings);
    }
}
