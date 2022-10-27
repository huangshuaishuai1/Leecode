package ershua;

public class T28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            int left = i+1;
            int right = i + len - 1;
            int index = 1;
            while (left <= right) {
                if (haystack.charAt(left) == needle.charAt(index)
                && haystack.charAt(right) == needle.charAt(len - index)) {
                    left++;
                    right--;
                    index++;
                }else {
                    break;
                }
            }
            if (left > right) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        T28 t28 = new T28();


        System.out.println(t28.strStr( "mississippi", "issipi"));
    }
}
