package tree;

import java.util.ArrayList;
import java.util.List;

public class T145After {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        getTreePos(integers,root);
        return integers;
    }

    public static void getTreePos(ArrayList<Integer> arrayList,TreeNode node) {
        if (node==null){
            return;
        }

        getTreePos(arrayList,node.left);
        getTreePos(arrayList,node.right);
        arrayList.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        root.right = t2;
        t2.left = t3;


        T145After t145After = new T145After();
        List<Integer> integers = t145After.postorderTraversal(root);
        System.out.println(integers);


    }
}
