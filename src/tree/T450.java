package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;

public class T450 {
    public TreeNode deleteNode(TreeNode root, int key) {
       root = delet(root,key);
       return root;
    }

    private TreeNode delet(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = delet(root.left,key);
        }else if (root.val < key) {
            root.right = delet(root.right,key);
        }else {
            if (root.left ==null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode temp = root.right;
            while (temp.left !=null) {
                temp = temp.left;
            }
            root.val = temp.val;
            root.right = delet(root.right,temp.val);

        }return root;
    }


    public static void main(String[] args) {
        T450 t450 = new T450();
        TreeNode treeNode = new TreeNode(5);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        treeNode.right = t2;
        treeNode.left = t1;
        t1.left = t3;
        t1.right = t4;
        t2.right = t5;
        TreeNode treeNode1 = t450.deleteNode(treeNode, 6);

        System.out.println(treeNode1);
    }
}
