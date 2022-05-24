package stack;

public class T1047_StringBuffer {
    //abbacaa
    public String removeDuplicates(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top>=0 && stringBuffer.charAt(top)==c){
                stringBuffer.deleteCharAt(top);
                top--;
            }else {
                stringBuffer.append(c);
                top++;
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        T1047_StringBuffer t1047 = new T1047_StringBuffer();

        String s = t1047.removeDuplicates("abacaa");
        System.out.println("s = " + s);
    }
}
