package ershua;

public class offer58 {
    public String reverseLeftWords(String s, int n) {
        char[] temp = new char[n];
        for (int i = 0; i < n; i++) {
            temp[i] = s.charAt(i);
        }
        char[] toCharArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - n) {
                toCharArray[i] = toCharArray[i+n];
            }else {
                toCharArray[i] = temp[i - s.length() + n];
            }
        }
        return new String(toCharArray);
    }

    public static void main(String[] args) {
        offer58 offer58 = new offer58();
        System.out.println(offer58.reverseLeftWords("abcdefg", 6));
    }
}
