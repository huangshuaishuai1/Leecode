package nenglian;

import java.util.ArrayList;

public class T22 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> list = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(2);
            list.addAll(list1);
        });

        Thread thread2 = new Thread(() -> {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(3);
            list1.add(4);
            list.addAll(list1);
        });
        Thread thread3 = new Thread(() -> {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(5);
            list1.add(6);
            list.addAll(list1);
        });
        Thread thread4 = new Thread(() -> {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(7);
            list1.add(8);
            list.addAll(list1);
        });
        Thread thread5 = new Thread(() -> {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(9);
            list1.add(10);
            list.addAll(list1);
        });
        Thread thread6 = new Thread(() -> {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(11);
            list1.add(12);
            list.addAll(list1);
        });
        Thread thread7 = new Thread(() -> {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(13);
            list1.add(14);
            list.addAll(list1);
        });
        Thread thread8 = new Thread(() -> {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(15);
            list1.add(16);
            list.addAll(list1);
        });
        Thread thread9 = new Thread(() -> {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(17);
            list1.add(18);
            list.addAll(list1);
        });

        thread1.start();
        thread2.start();
        thread4.start();
        thread3.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();

        System.out.println(list);
        System.out.println(list.size());
    }


}
