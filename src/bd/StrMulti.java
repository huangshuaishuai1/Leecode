package bd;

public class StrMulti {

    public static void main(String[] args) {
        StrMulti strMulti = new StrMulti();
        System.out.println(strMulti.multiply("13", "0"));
    }
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0" .equals(num2)) {
            return "0";

        }
        String ans = "0";
        for(int i = num2.length() - 1; i >= 0; i--) {
            int a = num2.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            int forward = 0;
            for(int j = num1.length() - 1; j >= 0; j --) {
                int b = num1.charAt(j) - '0';
                int mul = a * b + forward;
                forward = mul / 10;
                sb.append(mul % 10);
            }
            if(forward != 0) {
                sb.append(forward);
            }
            sb.reverse();
            for(int j = 0; j < num2.length() -1 - i; j ++) {
                sb.append(0);
            }
            String tmp = new String(sb);
            ans = addStrings(ans,tmp);
        }
        return ans;
    }


    public static String addStrings(String num1, String num2) {

        StringBuilder n1 = new StringBuilder(num1);
        StringBuilder n2 = new StringBuilder(num2);
        n1.reverse();
        n2.reverse();
        StringBuilder ret = new StringBuilder();
        int i = 0;
        int forward = 0;
        while(i < n1.length() && i < n2.length()) {
            int a = n1.charAt(i) - '0';
            int b = n2.charAt(i) - '0';

            int sum = a+b+forward;
            forward = sum / 10;
            ret.append(sum % 10);
            i++;
        }
        while(n1.length() > i && i < n1.length()) {
            int a = n1.charAt(i) - '0';
            int sum = a + forward;
            forward = sum / 10;
            ret.append(sum % 10);
            i++;
        }

        while(n2.length() > i && i < n2.length()) {
            int a = n2.charAt(i) - '0';
            int sum = a + forward;
            forward = sum / 10;
            ret.append(sum % 10);
            i++;
        }
        if(forward != 0) {
            ret.append(forward);
        }
        ret.reverse();
        return new String(ret);
    }
}
