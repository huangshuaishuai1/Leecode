package meituan;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import tree.TreeNode;

import java.util.*;

public class t1 {
        public static void main(String[] args) {
            t1 t1 = new t1();
            TreeNode root = new TreeNode(-1);
            root.left = new TreeNode(-1);
            root.right = new TreeNode(-1);

            TreeNode ret = t1.helper(root);
            System.out.println(111);


        }
        static List<Integer> levellist=new ArrayList<>();

        TreeNode helper(TreeNode root) {
            // 层次遍历计算n
            levelorder(root);
            int n = levellist.size();
            ArrayList<Integer> single = new ArrayList<>();
            ArrayList<Integer> dou = new ArrayList<>();
            int tag = 1;
            int i = n;
            while(i > 0) {
                if (tag == 1) {
                    single.add(i);
                    i--;
                    if (i > 0) {
                        dou.add(i);
                        i--;
                    }
                    tag = 0;
                }else {
                    dou.add(i);
                    i--;
                    if (i>0) {
                        single.add(i);
                        i--;
                    }
                    tag = 1;
                }
            }
            if (single.size() < dou.size()) {
                ArrayList list = single;
                single = dou;
                dou = list;
            }
            TreeNode tmp = null;
            TreeNode treeNode = new TreeNode(single.get(0));
            tmp = new TreeNode(dou.get(0));
            treeNode.left = tmp;
            int less = Math.min(single.size(),dou.size());
            for (int j = 1; j < less; j++) {
                TreeNode tmp1 = null;
                tmp1 = new TreeNode(single.get(j));
                tmp.left = tmp1;
                tmp = tmp1;
                tmp1 = new TreeNode(dou.get(j));
                tmp.left = tmp1;
                tmp = tmp.left;
            }
            if (single.size() > dou.size()) {
                TreeNode tmp1 = null;
                tmp1 = new TreeNode(single.get(less));
                tmp.left = tmp1;
            }

            return treeNode;

        }
    public static void levelorder(TreeNode root) {
            if (root == null) {//空树
                 return;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);//offer方法表示添加元素到队尾
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();//poll方法删除队头元素
                levellist.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
}


