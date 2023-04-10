package niuke;

public class TengY3 {

    public static void main(String[] args) {
        TengY3 tengY3 = new TengY3();
        System.out.println(tengY3.getCnt("aABbbC"));
    }

    public int getCnt (String str) {
        // write code here
        String strLow = str.toLowerCase();

        int count = 0;
        for (int i = 0; i < str.length()-1; i++) {
            if (strLow.charAt(i) == strLow.charAt(i+1)) {
                count++;
            }
        }
        return count;
    }
}
