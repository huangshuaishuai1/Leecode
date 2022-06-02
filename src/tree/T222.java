package tree;

import java.util.LinkedList;
import java.util.Queue;

public class T222 {
    public int countNodes(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return 0;
        }
        queue.add(root);
        ret = 1;
        int level = 1;
        int tag = 0;
        while(!queue.isEmpty()) {
            ret = ret + level*level;
            level++;
            int size = queue.size();
            while(size>0) {
                TreeNode poll = queue.poll();
                if(poll.right != null){
                    if (tag==1){
                        return ret;
                    }
                    queue.add(poll.right);
                }else{
                    tag=1;
                    ret--;
                    if(poll.left != null) {
                        queue.add(poll.left);
                        return ret;
                    }else{
                        ret--;
                    }
                }
                if(poll.left != null){
                    queue.add(poll.left);
                }
                size--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T222 t222 = new T222();
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        root.right = t3;
        root.left = t2;
        t2.left = t4;
        t2.right = t5;
        t3.left=t6;
        t3.right=t7;
        int i = t222.countNodes(root);
        System.out.println(i);
    }
}
