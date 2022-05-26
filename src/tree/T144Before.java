package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class T144Before {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        getTreePre(integers,root);
        return integers;
    }

    public static void getTreePre(ArrayList<Integer> arrayList,TreeNode node) {
        if (node==null){
            return;
        }
        arrayList.add(node.val);
        getTreePre(arrayList,node.left);
        getTreePre(arrayList,node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        root.left = t2;
        root.right = t2;
        t2.left = t3;
//        t2.right = t5;
//        t3.left = t6;
//        t3.right = t7;
//        t4.left=null;
//        t4.right=null;
//        t5.left=null;
//        t5.right=null;
//        t6.left=null;
//        t6.right=null;
//        t7.left=null;
//        t7.right=null;


        T144Before t144Before = new T144Before();
        List<Integer> integers = t144Before.preorderTraversal(root);
        System.out.println(integers);


    }
}
