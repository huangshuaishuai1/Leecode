package niuke;

import java.util.*;

public class TengY {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-1);
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(-1);
//        TreeNode node3 = new TreeNode(-1);
//        TreeNode node4 = new TreeNode(-1);
        node.left = node1;
        node.right = node2;
//        node1.right = node3;
//        node2.left = node4;

        TengY tengY = new TengY();
        tengY.fun(node);
        System.out.println(111);

    }

    public TreeNode fun (TreeNode root) {
        // 层次遍历拿到奇数节点个数和偶数节点个数
        int[] numbers = layer(root);
        int count = numbers[0] + numbers[1];
        //目标价值
        int taget = count*(1+count)/4;
        // 回溯找到目标和
        ArrayList<Integer> jishu = new ArrayList<>();
        int sum = 0;
        huiShu(taget,count,1,numbers[0],jishu);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < jishu.size(); i++) {
            sum+=jishu.get(i);
            set.add(jishu.get(i));
        }
        if (sum!=taget) {
            return null;
        }
        ArrayList<Integer> oushu = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            if (!set.contains(i)){
                oushu.add(i);
            }
        }

        // 根据奇数列表和偶数列表构建最终的树
        generateTree(root,jishu,oushu);
        return root;
    }

    private void generateTree(TreeNode root, ArrayList<Integer> jishu, ArrayList<Integer> oushu) {
        int i = 0;
        int j = 0;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        int tag = 0;
        while (treeNodes.size() != 0) {
            int size = treeNodes.size();
            if (tag == 0) {
                for (int k = 0; k < size; k++) {
                    TreeNode poll = treeNodes.poll();
                    poll.val = jishu.get(i);
                    i++;
                    if (poll.left!=null) {
                        treeNodes.add(poll.left);
                    }
                    if (poll.right!=null) {
                        treeNodes.add(poll.right);
                    }
                }
                tag=1;
            }else {
                for (int k = 0; k < size; k++) {
                    TreeNode poll = treeNodes.poll();
                    poll.val = oushu.get(j);
                    j++;
                    if (poll.left!=null) {
                        treeNodes.add(poll.left);
                    }
                    if (poll.right!=null) {
                        treeNodes.add(poll.right);
                    }
                }
                tag=0;
            }
        }
    }

    static int sum = 0;
    private void huiShu(int taget, int count, int startIndex, int size, ArrayList<Integer> jishu) {
        if (sum == taget && jishu.size() == size) {
            return;
        }

        for (int i = startIndex; i <= count; i++) {
            if(sum + i > taget) {
                break;
            }
            sum += i;
            jishu.add(i);
            if (sum <= taget) {
                huiShu(taget,count,i+1,size,jishu);
                if (sum == taget && jishu.size() == size) {
                    return;
                }
                // 回溯
                jishu.remove(jishu.size()-1);
                sum-=i;
            }
        }
    }

    private int[] layer(TreeNode root) {
        // 奇数层节点总数
        int j = 0;
        // 偶数层节点总数
        int o = 0;
        int[] ints = new int[2];
        Queue<TreeNode> nodes = new LinkedList<>();
        if (root == null) {
            ints[0] = j;
            ints[1] = o;
            return ints;
        }
        int tag = 0;  // 0表示奇数层，1表示偶数层
        nodes.add(root);
        while (nodes.size()!=0) {
            int size = nodes.size();
            if (tag == 0) {
                j+=size;
                tag=1;
            }else {
                o+=size;
                tag=0;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if (node.left!=null) {
                    nodes.add(node.left);
                }
                if (node.right!=null) {
                    nodes.add(node.right);
                }
            }
        }
        ints[0] = j;
        ints[1] = o;
        return ints;
    }

}
