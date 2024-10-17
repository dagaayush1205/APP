import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class seven {
    public static void main(String[] args) {
        // Anonymous function to square each element in a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> squaredNumbers = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("Squared: " + squaredNumbers);

        // Anonymous function to filter even numbers from a list
        List<Integer> moreNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = moreNumbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);
    }
}

