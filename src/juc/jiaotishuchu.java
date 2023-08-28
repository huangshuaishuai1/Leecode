package juc;

import java.util.concurrent.locks.LockSupport;

public class jiaotishuchu {
    // 交替输出 1A2B3C4D
    static Thread  t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {

        t1 = new Thread(() -> {
            LockSupport.park();
            System.out.println("A");
            LockSupport.unpark(t2);
            LockSupport.park();
            System.out.println("B");
            LockSupport.unpark(t2);
            LockSupport.park();
            System.out.println("C");
            LockSupport.unpark(t2);
            LockSupport.park();
            System.out.println("D");
            LockSupport.unpark(t2);
        });

        t2 = new Thread(() -> {
            System.out.println("1");
            LockSupport.unpark(t1);
            LockSupport.park();
            System.out.println("2");
            LockSupport.unpark(t1);
            LockSupport.park();
            System.out.println("3");
            LockSupport.unpark(t1);
            LockSupport.park();
            System.out.println("4");
            LockSupport.unpark(t1);
            LockSupport.park();
        });
        t1.start();
        t2.start();
    }
}
