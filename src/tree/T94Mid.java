package tree;

import java.util.ArrayList;
import java.util.List;

public class T94Mid {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        getTreeIno(integers,root);
        return integers;
    }

    public static void getTreeIno(ArrayList<Integer> arrayList,TreeNode node) {
        if (node==null){
            return;
        }

        getTreeIno(arrayList,node.left);
        arrayList.add(node.val);
        getTreeIno(arrayList,node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        root.right = t2;
        t2.left = t3;


        T94Mid t94Mid = new T94Mid();

        List<Integer> integers = t94Mid.inorderTraversal(root);
        System.out.println(integers);


    }
}
