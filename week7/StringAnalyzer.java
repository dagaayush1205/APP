class ThreadA extends Thread {
    private String k;
    private int dc = 0; // Digits count

    public ThreadA(String k) {
        this.k = k;
    }

    @Override
    public void run() {
        // Count the number of digits in the string
        for (char ch : k.toCharArray()) {
            if (Character.isDigit(ch)) {
                dc++;
            }
        }
        // Print the digit count
        System.out.println("ThreadA: " + dc);
    }
}

class ThreadB extends Thread {
    private String k;
    private int cc = 0; // Alphabetic count

    public ThreadB(String k) {
        this.k = k;
    }

    @Override
    public void run() {
        // Count the number of alphabetic characters in the string
        for (char ch : k.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                cc++;
            }
        }
        // Print the alphabetic count
        System.out.println("ThreadB: " + cc);
    }
}

public class StringAnalyzer {
    public static void main(String[] args) {
        // Input string to analyze
        String k = "Hello123World456";

        // Create instances of ThreadA and ThreadB
        ThreadA threadA = new ThreadA(k);
        ThreadB threadB = new ThreadB(k);

        // Start both threads
        threadA.start();
        threadB.start();
    }
}

