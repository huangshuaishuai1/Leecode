package demo.tryDemo;

public class Demo {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        try {
            int a = 1;
            System.out.println("try");
//            a = 1/0;
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("哈哈哈哈");
            return 0;
        }
    }
}
