package meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T1 {

    private String name;
    private String ename;

    public static void main(String[] args) {
        T1 t1 = new T1("11", "11");

        ArrayList<int[]> list = new ArrayList<>();
        int[][] arr = new int[2][2];
        arr[0] = new int[]{1,2};
        arr[1] = new int[]{2,4};
        List<int[]> collect = Arrays.stream(arr).sorted((int[] a, int[] b) -> a[0] - b[0]).collect(Collectors.toList());
    }

    public T1(String name, String ename) {
        this.name = name;
        this.ename = ename;
    }
}

