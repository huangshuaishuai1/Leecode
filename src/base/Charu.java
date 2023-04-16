package base;

public class Charu {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, 2, 4, 3, 6};
        insert(numbers);
        System.out.println(111);
    }

    private static void insert(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {
            int num = numbers[i];
            for (int j = i-1; j >=0 ; j--) {
                if (num < numbers[j]) {
                    numbers[j+1] = numbers[j];
                }else {
                    numbers[j+1] = num;
                    break;
                }
            }
        }
    }
}
