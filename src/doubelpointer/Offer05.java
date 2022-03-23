package doubelpointer;

public class Offer05 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int spaceNum = 0;
        //先知道里有多少个空格
        while (i < s.length()) {
            if (chars[i] == ' ') {
                spaceNum++;
            }
            i++;
        }

        char[] ret = new char[s.length() + 2*spaceNum];
        i = 0;
        int j = 0;
        while (i < s.length()) {
            if (chars[i] != ' ') {
                ret[j] = chars[i];
                i++;
                j++;
            }
            else {
                ret[j] = '%';
                ret[j+1] = '2';
                ret[j+2] = '0';
                j+=3;
                i++;
            }
        }
        String r = new String(ret);
        return r;
    }

    public static void main(String[] args) {
        Offer05 offer05 = new Offer05();
        String s = offer05.replaceSpace("We are happy.");
        System.out.println(s);

    }
}
