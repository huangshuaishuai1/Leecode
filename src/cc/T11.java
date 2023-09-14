package cc;

/**
 * 交替打印010101
 */
public class T11 {
    static Thread t1;
    static Thread t2;
    public static void main(String[] args) {
        Object lock0 = new Object();
//        Object lock1 = new Object();
        t1 = new Thread(()->{
            while (true) {
                synchronized (lock0) {
                    try {
                        System.out.print(0);
                        lock0.notify();
                        lock0.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t2 = new Thread(()->{
            while (true) {
                synchronized (lock0) {
                    try {
                        System.out.print(1);
                        lock0.notify();
                        lock0.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
