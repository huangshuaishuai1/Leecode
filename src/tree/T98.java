package tree;

import java.util.LinkedList;
import java.util.PropertyResourceBundle;
import java.util.TreeMap;

public class T98 {

    public boolean isValidBST(TreeNode root) {
       //中序遍历
        LinkedList<Integer> ret = new LinkedList<>();
        LinkedList<Integer> mid = mid(ret, root);
        for (int i = 1; i < mid.size(); i++) {
            Integer i1 = mid.get(i);
            Integer integer = mid.get(i - 1);
            if (i1 <= integer) {
                return false;
            }
        }
        return true;
    }


    LinkedList<Integer> mid(LinkedList<Integer> ret, TreeNode root) {
        if (root.left != null) {
            mid(ret,root.left);
        }
        ret.add(root.val);
        if (root.right != null) {
            mid(ret,root.right);
        }
        return ret;
    }
    public static void main(String[] args) {
        T98 t98 = new T98();
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(6);
        root.right = t2;
        root.left = t1;
        t2.left = t3;
        t2.right = t4;
        System.out.println(t98.isValidBST(root));
    }
}
