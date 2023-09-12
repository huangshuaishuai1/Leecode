package tencent;

import tree.TreeNode;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
    static int ans = 0;
    public int pathNumber (TreeNode root) {
        // write code here
        int tmp = 0;
        backStracking(root,0,0 );
        tmp++;
        return ans;
    }

    static void backStracking(TreeNode root, int a, int b) {
        if (root.val == 0) {
            b++;
        }else {
            a++;
        }
        if (root.right == null&&root.left==null) {
            if (a-b==1){
                ans++;
            }
            return;
        }
        if (root.right != null) {
            backStracking(root.right,a,b);
        }
        if (root.left!=null) {
            backStracking(root.left,a,b);
        }
    }
}
