package hot100;

public class TT415 {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num1);

        sb1.reverse();
        sb2.reverse();

        StringBuilder ansSb = new StringBuilder();
        int tmp = 0;

        int len = Math.min(num1.length(), num2.length());

        for(int i = 0; i < len; i++) {
            int number1 = sb1.charAt(i) - '0';
            int number2 = sb2.charAt(i) - '0';
            int sum = number1 + number2 + tmp;

            ansSb.append(sum % 10);
            tmp = sum / 10;
        }
        if(num1.length() > len) {
            for(int i = len; i < num1.length(); i++) {
                int sum = sb1.charAt(i) - '0' + tmp;
                ansSb.append(sum % 10);
                tmp = sum / 10;
            }
        } else if(num2.length() > len) {
            for(int i = len; i < num2.length(); i++) {
                int sum = sb2.charAt(i) - '0' + tmp;
                ansSb.append(sum % 10);
                tmp = sum / 10;
            }
        }
        if(tmp != 0) {
            ansSb.append(tmp);
        }
        ansSb.reverse();
        return new String(ansSb);

    }
}
