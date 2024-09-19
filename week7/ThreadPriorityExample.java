import java.util.Scanner;

class UserThreadPriority extends Thread {
    private String k; // The string input
    private char c;   // The character input

    public UserThreadPriority(String k, char c) {
        this.k = k;
        this.c = c;
    }

    @Override
    public void run() {
        // Print which thread is running and what values it has
        System.out.println(getName() + " is running.");
        System.out.println(getName() + ": String = " + k + ", Character = " + c);
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Get a string from the user
        System.out.print("Enter a string: ");
        String userString = scanner.nextLine();

        // Get a character from the user
        System.out.print("Enter a character: ");
        char userChar = scanner.next().charAt(0);

        // Create two objects of UserThreadPriority class
        UserThreadPriority threadobj1 = new UserThreadPriority(userString, userChar);
        UserThreadPriority threadobj2 = new UserThreadPriority(userString, userChar);

        // Set the names of the threads
        threadobj1.setName("ThreadA");
        threadobj2.setName("ThreadB");

        // Start the threads
        threadobj1.start();
        threadobj2.start();

        // Close the scanner
        scanner.close();
    }
}

