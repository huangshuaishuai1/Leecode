package xy;

import java.util.concurrent.locks.LockSupport;

public class T1 {
    static Thread t1 = null;
    static Thread t2 = null;
    static Thread t3 = null;
    public static void main(String[] args) {
        final int[] a = {0};
        t1 = new Thread(()->{
            while (true) {
                if (a[0] == 10) {
                    LockSupport.unpark(t2);
                    break;
                }
                System.out.print("A");
                LockSupport.unpark(t2);
                a[0]++;
                LockSupport.park();
            }
        });
        t2 = new Thread(()->{
            while (true) {
                LockSupport.park();
                System.out.print("B");
                LockSupport.unpark(t3);
                if (a[0] == 10) {
                    break;
                }
            }
        });
        t3 = new Thread(()->{
            while (true) {
                LockSupport.park();
                System.out.print("C");
                LockSupport.unpark(t1);
                if (a[0] == 10) {
                    break;
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
