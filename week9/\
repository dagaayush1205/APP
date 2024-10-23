import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class three {

    // Pure function to find the maximum value in a list
    public static Integer findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElse(null);
    }

    // Impure function to sort a list of numbers in ascending order
    public static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);  // Modifies the original list
        System.out.println("Sorted Numbers: " + numbers);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 4);

        // Call the pure function to find the maximum value
        Integer max = findMax(numbers);
        System.out.println("Maximum Value: " + max);

        // Call the impure function to sort the list
        sortNumbers(numbers);
    }
}

