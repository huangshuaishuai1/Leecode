package xy;

import java.util.concurrent.locks.LockSupport;

public class T3 {
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        t1 = new Thread(()->{
            System.out.print("AA");
            // 唤醒t2
            LockSupport.unpark(t2);
            // 把自己阻塞住
            LockSupport.park();
            System.out.print("CC");
            // 唤醒t2
            LockSupport.unpark(t2);
            // 把自己阻塞住
            LockSupport.park();
            System.out.print("EE");
            // 唤醒t2
            LockSupport.unpark(t2);

        });
        t2 = new Thread(()->{
            // 把自己阻塞住
            LockSupport.park();
            System.out.print("BB");
            // 唤醒t1
            LockSupport.unpark(t1);
            // 把自己阻塞住
            LockSupport.park();
            System.out.print("DD");
            // 唤醒t1
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}

