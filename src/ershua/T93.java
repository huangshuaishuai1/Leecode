package ershua;

import java.util.ArrayList;
import java.util.List;

public class T93 {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<>();
        if (s.length() > 12) {
            return ret;
        }
        StringBuffer sb = new StringBuffer();
        int dotNum = 0;
        int startIndex = 0;
        backStracking(s,sb,ret,dotNum,startIndex);
        return ret;
    }

    private void backStracking(String s, StringBuffer sb, ArrayList<String> ret, int dotNum, int startIndex) {
        // 收集条件
        if (dotNum == 3){
            String substring = s.substring(startIndex);
            String s1 = new String(sb + substring);
            if (isIp(s1)) {
                ret.add(s1);
            }
            return;
        }

        for (int i = startIndex; i < s.length()-(3-dotNum); i++) {
            sb.append(s.charAt(i));
            sb.append(".");
            backStracking(s,sb,ret,dotNum+1,i+1);
            // 回溯
            while (sb.charAt(sb.length()-1) != '.') {
                sb.deleteCharAt(sb.length()-1);
            }
            sb.deleteCharAt(sb.length()-1);
        }

    }

    private boolean isIp(String s1) {
        String[] split = s1.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String s : split) {
            if (s.charAt(0) == '0' && s.length() > 1) {
                return false;
            }
            if (Integer.parseInt(s) > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T93 t93 = new T93();
        List<String> strings = t93.restoreIpAddresses("1231231231234");
        System.out.println(strings);
    }
}
