package singleton;

/**
 * 双重检查锁单例模式
 */
public class DclSingleton {

    private static volatile  DclSingleton dclSingleton;


    public DclSingleton getDclSingleton() {
        if (dclSingleton == null) {
            synchronized (DclSingleton.class) {
                if (dclSingleton == null) {
                    dclSingleton = new DclSingleton();
                    return dclSingleton;
                }
            }
        }

        return dclSingleton;
    }
}
