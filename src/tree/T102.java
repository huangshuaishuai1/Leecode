package tree;

import java.util.ArrayList;
import java.util.List;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<TreeNode> levelNode = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        ArrayList<TreeNode> tempNode = new ArrayList<>();

        if (root!=null) {
            levelNode.add(root);
        }else {
            return lists;
        }
        for(TreeNode treeNode: levelNode) {
            level.add(treeNode.val);
            if (treeNode.left!=null) {
                tempNode.add(treeNode.left);
            }
            if (treeNode.right!=null){
                tempNode.add(treeNode.right);
            }
        }
        lists.add(new ArrayList<Integer>(level));
        level.clear();
        levelNode.clear();
        levelNode.addAll(tempNode);
        tempNode.clear();
        while (levelNode.size()!=0) {
            for(TreeNode treeNode: levelNode) {
                level.add(treeNode.val);
                if (treeNode.left!=null) {
                    tempNode.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    tempNode.add(treeNode.right);
                }
            }

            lists.add(new ArrayList<Integer>(level));
            level.clear();
            levelNode.clear();
            levelNode.addAll(tempNode);
            tempNode.clear();
        }
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
        T102 t102 = new T102();
        List<List<Integer>> integers = t102.levelOrder(root);
        System.out.println(integers);

    }
}
