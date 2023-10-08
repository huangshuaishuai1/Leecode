package demo.init;

public class A {

    static {
        System.out.println("A方法被初始化了");
    }

    static int num1 = 1;
    static final int num2 = 2;

    static final int num3 = Integer.parseInt("3");

    static final String str1 = "str1";

    static final String str2 = new String("str2");

    static int[] arr1 = {1,2};

    static final int[] arr2 = {1,2};

    static  String[] arr3 = {"1","2"};

    static final String[] arr4 = {"1","2"};

    static void test() {
        System.out.println("!11");
    }
}
