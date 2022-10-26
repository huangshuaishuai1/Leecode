package ershua;

public class offer05 {

    public String replaceSpace(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count ++ ;
            }
        }
        char[] retChar = new char[s.length() + 2*count];
        int index = retChar.length-1;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i) == ' ') {
                retChar[index--] = '0';
                retChar[index--] = '2';
                retChar[index--] = '%';
            }else {
                retChar[index--] = s.charAt(i);
            }
        }
        return new String(retChar);
    }
}
