package hot100;

public class T5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String ret = "";
        int retLen = 0;
        int len = s.length();
        char[] array = s.toCharArray();
        for(int i = 0; i < len-1; i++) {
            int left = i;
            int right = i;
            while (left > 0 && array[left - 1] == array[left]) {
                left--;

            }
            while(right < len - 1 && array[right+1] == array[right]) {
                right++;
            }
            int temLen = right-left+1;
            if(temLen > retLen) {
                retLen = temLen;
                ret = s.substring(left,right+1);
            }
            while(left > 0 && right < len-1) {
                if(array[left-1] == array[right+1]) {
                    left--;
                    right++;
                    temLen = right-left+1;
                    if(temLen > retLen) {
                        retLen = temLen;
                        ret = s.substring(left,right+1);
                    }
                }else{
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        T5 t5 = new T5();
        System.out.println(t5.longestPalindrome("aaaa"));
    }
}
