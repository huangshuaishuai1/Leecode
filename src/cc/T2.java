package cc;

import java.util.concurrent.locks.LockSupport;

/**
 * 三个线程交替打印123
 */
public class T2 {

    static Thread t1 = null;
    static Thread t2 = null;
    static Thread t3 = null;
    public static void main(String[] args) {
        final int[] a = {0};

        t1 = new Thread(()->{
            while (true) {
                if (a[0] == 100) {
                    break;
                }
                System.out.println(1);
                LockSupport.unpark(t2);
                a[0] ++;
                LockSupport.park();
            }
        },"print 1");

        t2 = new Thread(()->{
            while (true) {
                LockSupport.park();
                System.out.println(2);
                LockSupport.unpark(t3);
                if (a[0] == 100) {
                    break;
                }
            }
        },"print 2");

        t3 = new Thread(()->{
            while (true) {
                LockSupport.park();
                System.out.println(3);
                LockSupport.unpark(t1);
                if (a[0] == 100) {
                    break;
                }
            }
        },"print 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
