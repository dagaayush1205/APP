import java.util.List;

public class threepurefunc {
    // Pure function to find the maximum value in a list
    public static int findMax(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 5, 7, 2, 8);
        int max = findMax(numbers);
        System.out.println("The maximum value is: " + max);
    }
}
