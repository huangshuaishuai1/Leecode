package tree;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

//106. 从中序与后序遍历序列构造二叉树
public class T106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree1(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode buildTree1 (int[] inorder, int inorderLeft, int inorderRight, int[] postorder,
                                int postorderLeft, int postorderRight) {
        if (inorderRight - inorderLeft < 0) {
            return null;
        }
        // 只有一个元素了
        if (inorderRight - inorderLeft == 0) {
            return new TreeNode(inorder[inorderLeft]);
        }
        int rootNum = postorder[postorderRight];
        TreeNode root = new TreeNode(rootNum);
        int indexOfInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootNum == inorder[i]) {
                indexOfInorder = i;
                break;
            }
        }

        root.left = buildTree1(inorder,inorderLeft,indexOfInorder-1,postorder,postorderLeft,indexOfInorder-1-(inorderRight-postorderRight));
        root.right = buildTree1(inorder,indexOfInorder+1,inorderRight,postorder,postorderLeft + indexOfInorder-inorderLeft,postorderRight-1);
        return root;
    }

    public static void main(String[] args) {
        T106 t106 = new T106();
        TreeNode treeNode = t106.buildTree(new int[]{-4,-10,3,-1,7,11,-8,2}, new int[]{-4,-1,3,-10,11,-8,2,7});
        System.out.println(treeNode);
    }
}
