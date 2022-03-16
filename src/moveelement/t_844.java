package moveelement;

public class t_844 {
    public boolean backspaceCompare(String s, String t) {
        String s1 = f(s);
        String s2 = f(t);
        if (s1.equals(s2)) {
            return true;
        }else {
            return false;
        }



    }
    public String f(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (chars[right] != '#') {
                chars[left++] = chars[right];
            } else if (left != 0){
                left --;
            }
            right ++;
        }
        String s1 = new String(chars);
        s1 = s1.substring(0,left);
        return s1;
    }

    public static void main(String[] args) {
        t_844 t_844 = new t_844();
        String s = "a##c";
        String t = "#a#c";
        boolean result = t_844.backspaceCompare(s, t);
        System.out.println(result);
    }
}
