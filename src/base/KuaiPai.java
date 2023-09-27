package base;

public class KuaiPai {

    public static void main(String[] args) {
        int[] numbers = {1, 6, 7, 2, 4, 3, 5};
        quick(numbers,0,numbers.length-1);
        System.out.println(111);
    }
    private static void quick(int[] numbers, int l, int h) {
        if (l >= h) {
            return;
        }
        int next = partition(numbers,l,h);
        quick(numbers,l,next-1);
        quick(numbers,next+1,h);
    }
    private static int partition(int[] numbers, int l, int h) {
        int i = l;
        for (int j = l; j < h; j++) {
            if (numbers[h] > numbers[j]) {
                int tmp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = tmp;
                i++;
            }
        }
        int tmp = numbers[h];
        numbers[h] = numbers[i];
        numbers[i] = tmp;
        return i;
    }


}
