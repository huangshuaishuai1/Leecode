package tree;

import java.util.*;

public class T104 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode>  queue= new LinkedList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (root != null){
            queue.add(root);
        }
        else{
            return lists;
        }
        while (queue.size() >0) {
            ArrayList<Integer> items = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode poll = queue.poll();
                items.add(poll.val);

                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                len --;
            }
            lists.add(items);
        }
        Collections.reverse(lists);
        return lists;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        root.right = t3;
        root.left = t2;
        t3.left = t4;
        t3.right = t5;
        T104 t104 = new T104();
        List<List<Integer>> integers = t104.levelOrderBottom(root);

        System.out.println(integers);

    }
}
