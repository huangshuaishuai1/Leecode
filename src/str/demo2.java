package str;


public class demo2 {

    public static void main(String[] args) {
        demo demo = new demo(new int[]{1, 2, 3});
        int[] val = demo.getVal();
        val[1] = 33;
        System.out.println(demo.getVal()[1]);
    }

}
