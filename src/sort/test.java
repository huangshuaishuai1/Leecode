package sort;

public class test {

//    public static void main(String[] args) {
        public static void main(String[] args) {
            new Thread(()->{
                try {
                    Thread.sleep(10000);
                    System.out.println("xxxx");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }).start();
        }
}
