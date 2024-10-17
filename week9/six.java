public class six {
    public static void main(String[] args) {
        // Anonymous function to add two numbers and immediately call it
        System.out.println("Sum: " + ((Add) (a, b) -> a + b).operate(5, 3));

        // Anonymous function to multiply two numbers, assigned to a variable
        Operation multiply = (a, b) -> a * b;
        System.out.println("Product: " + multiply.operate(4, 6));
    }
}

// Functional interface for operations
interface Operation {
    int operate(int a, int b);
}

interface Add extends Operation {}

