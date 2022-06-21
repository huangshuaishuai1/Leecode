package backstracking;

import java.util.LinkedList;
import java.util.List;

public class T93 {
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> ret = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        LinkedList<String> items = new LinkedList<>();
        int count = 0;
        int startIndex = 0;
        backStracking(s,ret,sb,count,startIndex,items);
        return ret;
    }
    public void backStracking(String s, LinkedList<String> ret, StringBuilder sb, int count, int startIndex,LinkedList<String> items) {
        // 终止条件1：
        if (count == 3) {
            if (startIndex < s.length() && isIp(s.substring(startIndex))) {
                StringBuilder stringBuilder = new StringBuilder(sb);
                stringBuilder.append(s.substring(startIndex));
                ret.add(new String(stringBuilder));

            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isIp(s.substring(startIndex,i+1))) {
                String substring = s.substring(startIndex, i + 1);
                items.add(substring);
                sb.append(substring);
                sb.append(".");
                count ++;
                backStracking(s,ret,sb,count,i+1,items);
                // 回溯
                String s1 = items.removeLast();
                int length = s1.length();
                sb.deleteCharAt(sb.length()-1);
                sb.delete(sb.length()-length,sb.length());
                count--;
            }else {
                return;
            }
        }
    }

    public boolean isIp(String ip) {
        if (ip.charAt(0)=='0' && ip.length()>1) {
            return false;
        }
        long i = Long.parseLong(ip);
        if (i<= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        T93 t93 = new T93();
        List<String> strings = t93.restoreIpAddresses("0279245587303");
        System.out.println(strings);
    }
}
