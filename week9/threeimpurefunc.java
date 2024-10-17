import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class threeimpurefunc {
    // Impure function to sort a list of numbers in ascending order
    public static void sortList(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println("Sorted list: " + numbers);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(3, 5, 7, 2, 8));
        sortList(numbers); // This modifies and prints the list
    }
}
