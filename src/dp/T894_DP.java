package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T894_DP {
    public static void main(String[] args) {
        T894_DP t894Dp = new T894_DP();
        List<TreeNode> treeNodes = t894Dp.allPossibleFBT(7);
        System.out.println(treeNodes);
    }
    public List<TreeNode> allPossibleFBT(int n) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (n % 2 == 0) {
            return list;
        }

            list.add(new TreeNode(0));

        if (n == 1) {
            return list;
        }


        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        map.put(1,list);
        for (int l = 3; l <= n; l+=2) {
            ArrayList<TreeNode> tmp = new ArrayList<>();
            for (int i = 1; i < l; i+=2) {
                    List<TreeNode> left = map.get(i);
                    List<TreeNode> right = map.get(l-1-i);
                    for (TreeNode treeNode : left) {
                        for (TreeNode node : right) {
                            tmp.add(new TreeNode(0,treeNode,node));
                        }
                    }
                }
            map.put(l,tmp);


        }
        return map.get(n);

    }

}
