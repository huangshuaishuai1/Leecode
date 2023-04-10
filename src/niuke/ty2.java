package niuke;

import java.util.ArrayList;

public class ty2 {


    public static void main(String[] args) {
        ty2 ty2 = new ty2();
        ArrayList list1 = new ArrayList<Integer>();
        ArrayList list2 = new ArrayList<Integer>();
        list1.add(3);
        list1.add(3);
        list1.add(4);
        list1.add(4);
        list1.add(3);
        list2.add(3);
        list2.add(4);
        list2.add(4);
        list2.add(3);
        list2.add(3);
        ArrayList binaryTrees = ty2.getBinaryTrees(list1, list2);
    }

    
    public ArrayList<TreeNode> getBinaryTrees (ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        Integer rootVal = preOrder.get(0);
        ArrayList<TreeNode> ret1 = new ArrayList<>();
        for (int i = 0; i < inOrder.size(); i++) {
            if (inOrder.get(i) == rootVal) {
                // 在中序遍历中找到左子树和右子树
                ArrayList<Integer> leftPreOrder = new ArrayList<>();
                ArrayList<Integer> leftInOrder = new ArrayList<>();
                ArrayList<Integer> rightPreOrder = new ArrayList<>();
                ArrayList<Integer> rightInOrder = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    leftPreOrder.add(preOrder.get(j+1));
                    leftInOrder.add(inOrder.get(j));
                }
                for (int j = i+1; j < inOrder.size(); j++) {
                    rightPreOrder.add(preOrder.get(j));
                    rightInOrder.add(inOrder.get(j));
                }
                ArrayList<TreeNode> leftTrees = helper(leftPreOrder, leftInOrder);
                ArrayList<TreeNode> rightTrees = helper(rightPreOrder, rightInOrder);
                if (leftTrees != null) {
                    for (TreeNode leftTree : leftTrees) {
                        if (rightTrees != null) {
                            for (TreeNode rightTree : rightTrees) {
                                TreeNode root = new TreeNode(rootVal);
                                root.left = leftTree;
                                root.right = rightTree;
                                ret1.add(root);
                            }
                        }else {
                            TreeNode root = new TreeNode(rootVal);
                            root.left = leftTree;
                            root.right = null;
                            ret1.add(root);
                        }
                    }
                }else{
                    if (rightTrees!=null) {
                        for (TreeNode rightTree : rightTrees) {
                            TreeNode now = new TreeNode(rootVal);
                            now.left=null;
                            now.right = rightTree;
                            ret1.add(now);
                        }
                    }else {
                        TreeNode now = new TreeNode(rootVal);
                        now.left=null;
                        now.right = null;
                        ret1.add(now);
                    }
                }
            }
        }
        return ret1;

    }

    private ArrayList<TreeNode> helper(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        if (preOrder.size() == 0) {
            return null;
        }
        Integer nowVal = preOrder.get(0);
        // 拿到当前根节点
        ArrayList<TreeNode> ret = new ArrayList<>();

        for (int i = 0; i < inOrder.size(); i++) {
            if (inOrder.get(i) == nowVal) {
                // 在中序遍历中找到左子树和右子树
                ArrayList<Integer> leftPreOrder = new ArrayList<>();
                ArrayList<Integer> leftInOrder = new ArrayList<>();
                ArrayList<Integer> rightPreOrder = new ArrayList<>();
                ArrayList<Integer> rightInOrder = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    leftPreOrder.add(preOrder.get(j+1));
                    leftInOrder.add(inOrder.get(j));
                }
                for (int j = i+1; j < inOrder.size(); j++) {
                    rightPreOrder.add(preOrder.get(j));
                    rightInOrder.add(inOrder.get(j));
                }
                ArrayList<TreeNode> leftTrees = helper(leftPreOrder, leftInOrder);
                ArrayList<TreeNode> rightTrees = helper(rightPreOrder, rightInOrder);
                if (leftTrees != null) {
                    for (TreeNode leftTree : leftTrees) {
                        if (rightTrees != null) {
                            for (TreeNode rightTree : rightTrees) {
                                TreeNode now = new TreeNode(nowVal);
                                now.left = leftTree;
                                now.right = rightTree;
                                ret.add(now);
                            }
                        }else {
                            TreeNode now = new TreeNode(nowVal);
                            now.left = leftTree;
                            now.right = null;
                            ret.add(now);
                        }
                    }
                }else {
                    if (rightTrees!=null) {
                        for (TreeNode rightTree : rightTrees) {
                            TreeNode now = new TreeNode(nowVal);
                            now.left =null;
                            now.right = rightTree;
                            ret.add(now);
                        }
                    }else {
                        TreeNode now = new TreeNode(nowVal);
                        now.left =null;
                        now.right = null;
                        ret.add(now);
                    }
                }
            }
        }
        return ret;
    }
}
