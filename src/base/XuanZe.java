package base;

public class XuanZe {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, 2, 4, 3, 6};
        selection(numbers);
        System.out.println(111);
    }

    private static void selection(int[] numbers) {

        for (int i = 0; i < numbers.length-1; i++) {
            int index = i;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[index] > numbers[j]) {
                    index = j;
                }
            }
            int tmp = numbers[i];
            numbers[i] = numbers[index];
            numbers[index] = tmp;
        }
    }
}
