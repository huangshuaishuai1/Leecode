package tree;

import java.util.ArrayList;
import java.util.HashMap;

public class T501 {
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> midTree = new ArrayList<>();
        midOrder(root,midTree);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int maxCount = 0;
        int count = 1;
        for (int i = 0; i < midTree.size(); i++) {
            if (map.containsKey(midTree.get(i))) {
                map.put(midTree.get(i),map.get(midTree.get(i))+1);
                count++;
            }else {
                if (i != 0){
                    int preMax = maxCount;
                    maxCount = Math.max(maxCount,count);
                    if (preMax == count) {
                        list.add(midTree.get(i-1));
                    }else if (count > preMax){
                        list.clear();
                        list.add(midTree.get(i-1));
                    }
                    count = 1;
                }
                map.put(midTree.get(i),1);
            }
        }
        int preMax = maxCount;
        maxCount = Math.max(maxCount,count);
        if (preMax == count) {
            list.add(midTree.get(midTree.size()-1));
        }else if (count > preMax){
            list.clear();
            list.add(midTree.get(midTree.size()-1));
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }


    private void midOrder(TreeNode root, ArrayList midTree) {
        if (root.left != null) {
            midOrder(root.left,midTree);
        }
        midTree.add(root.val);
        if (root.right != null) {
            midOrder(root.right,midTree);
        }
    }
    public static void main(String[] args) {
        T501 t501 = new T501();

        TreeNode root = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(5);
        TreeNode t8 = new TreeNode(6);

        root.right = t1;
        root.left = t3;
        t1.left = t2;
        t1.right = t4;
        t4.left = t5;
        t4.right = t6;
        t6.left=t7;
        t6.right=t8;

        int[] mode = t501.findMode(root);
        System.out.println(mode);
    }

}
