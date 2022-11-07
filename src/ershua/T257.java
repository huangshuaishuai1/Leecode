package ershua;

import java.util.ArrayList;
import java.util.List;

public class T257 {

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        help(root,ret,sb);
        return ret;
    }

    private void help(TreeNode root, ArrayList<String> ret, StringBuilder sb) {
        if (root != null) {
            sb.insert(sb.length(),root.val);
            sb.insert(sb.length(),"->");
            help(root.left,ret,new StringBuilder(sb));
            help(root.right,ret,new StringBuilder(sb));
            if (root.left == null && root.right == null) {
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
                ret.add(new String(sb));
            }
        }
    }


}
