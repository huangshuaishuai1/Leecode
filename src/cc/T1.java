package cc;

import java.util.concurrent.locks.LockSupport;

/**
 * 交替打印 10101010
 */
public class T1 {
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        t1 = new Thread(() -> {
            while (true) {
                System.out.print(0);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2 =  new Thread(() -> {
            while (true) {
                LockSupport.park();
                System.out.print(1);
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }
}
