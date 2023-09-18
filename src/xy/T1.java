package xy;

import java.util.concurrent.locks.LockSupport;

public class T1 {
    static Thread t1 = null;
    static Thread t2 = null;
    static Thread t3 = null;

    public static void main(String[] args) {
        final int[] a = {0};
//        LockSupport.park(t2);
//        LockSupport.park(t3);
        t1 = new Thread(()->{
            while (true) {
                if (a[0] == 10) {
                    LockSupport.unpark(t2);
                    break;
                }
                System.out.print("A");
                // 唤醒t2
                LockSupport.unpark(t2);
                a[0]++;
                // 把自己阻塞住
                LockSupport.park();
            }
        });

        t2 = new Thread(()->{
            while (true) {
                // 把自己阻塞住
                LockSupport.park();
                System.out.print("B");
                // 唤醒t3
                LockSupport.unpark(t3);
                if (a[0] == 10) {
                    break;
                }
            }
        });
        t3 = new Thread(()->{
            while (true) {
                // 把自己阻塞住
                LockSupport.park();
                System.out.print("C");
                // 唤醒t1
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
