package noclass;

import java.util.ArrayList;
import java.util.List;

public class T970 {
    public static void main(String[] args) {
        T970 t970 = new T970();
        List<Integer> integers = t970.powerfulIntegers(2, 3, 10);
        System.out.println(integers);
    }
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();
        if (x == 1) {
            X.add(1);
        }
        if (y == 1) {
            Y.add(1);
        }
        int i = 0;
        while (x != 1) {
            int tmp = (int) Math.pow(x,i);
            if ( tmp  <= bound) {
                X.add(tmp);
                i++;
            }else {
                break;
            }
        }
        i = 0;
        while (y != 1) {
            int tmp = (int) Math.pow(y,i);
            if ( tmp  <= bound) {
                Y.add(tmp);
                i ++;
            }else {
                break;
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int j = 0; j < X.size(); j++) {
            for (int k = 0; k < Y.size(); k++) {
                int tmp = X.get(j) + Y.get(k);
                if (tmp <= bound) {
                    if (!ret.contains(tmp)){
                        ret.add(tmp);
                    }
                }else {
                    break;
                }
            }
        }
        return ret;
    }

}
