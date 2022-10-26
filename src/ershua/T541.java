package ershua;

public class T541 {
    public String reverseStr(String s, int k) {
        int index = 0;
        while (index+2*k < s.length()) {
            s = helper(s,index,index+k-1);
            index += 2*k;
        }
        if (s.length() - index >= k) {
            s = helper(s,index,index+k-1);
        }else {
            s = helper(s,index,s.length()-1);
        }
        return s;
    }
    public String helper(String s, int start, int end) {
        char[] chars = s.toCharArray();
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start ++;
            end --;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        T541 t541 = new T541();
        System.out.println(t541.reverseStr("abcd", 5));
    }
}
