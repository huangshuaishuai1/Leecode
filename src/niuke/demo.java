//package niuke;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//
//public class demo {
//
//    public static void main(String[] args) throws Exception {
//        // 获取类的字节码对象
//        Class clazz = Class.forName("niuke.User");
//        // 通过字节码对象得到类的指定方法
////        Method sayHello = clazz.getDeclaredMethod("sayHello");
////        User user = new User();
////        sayHello.invoke(user);
//        Constructor constructor = clazz.getConstructor();
//        User o = (User) constructor.newInstance();
//        Field name = clazz.getDeclaredField("name");
//        name.setAccessible(true);
//        name.set(o,"张三");
//        o.sayHello();
//        System.out.println(o.getName());
//    }
//
//
//}
