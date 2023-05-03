package str;

public class T1003 {
    public static void main(String[] args) {
        T1003 t1003 = new T1003();
        System.out.println(t1003.isValid("aababcbccabc"));
    }
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0 && sb.indexOf("abc") != -1) {
            int index = sb.indexOf("abc");
            sb.delete(index,index+3);
        }
        return sb.length()==0;
    }
}
