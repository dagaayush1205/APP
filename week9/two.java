import java.util.Scanner;

public class two {

    // Pure function to calculate the area of a circle
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Impure function that prompts the user and prints the area
    public static void promptAndPrintArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        double area = calculateArea(radius);  // Call the pure function
        System.out.println("The area of the circle is: " + area);
    }

    public static void main(String[] args) {
        promptAndPrintArea();  // Call the impure function
    }
}

