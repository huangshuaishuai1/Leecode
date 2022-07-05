package doubelpointer;



public class T151 {



    public String reverseWords(String s) {
        s = s.trim();
        String[] s1 = s.split(" ");
        String[] s2 = new String[s1.length];
        int len = 0;
        for (String str:
             s1) {
            if(!"".equals(str)){

                s2[len++] = str;
            }
        }
        String ret = s2[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            ret += " ";
            ret += s2[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        T151 t151 = new T151();
        String s = t151.reverseWords("  hello   world  ");
        System.out.println(s);
    }

}
