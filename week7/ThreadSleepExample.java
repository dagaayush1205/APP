class UserThreadPriority extends Thread {
    private String k; // String variable
    private char c;   // Character variable

    public UserThreadPriority(String k, char c) {
        this.k = k;
        this.c = c;
    }

    @Override
    public void run() {
        try {
            // Loop through different sleep intervals (in nanoseconds)
            long[] sleepIntervals = {10, 20, 50, 70, 100}; // Sleep times in nanoseconds

            for (long sleepTime : sleepIntervals) {
                // Print before sleeping
                System.out.println(getName() + " will sleep for " + sleepTime + " nanoseconds.");

                // Sleep for the specified nanosecond interval
                Thread.sleep(0, (int) sleepTime); // The first argument is milliseconds, the second is nanoseconds

                // Print after waking up
                System.out.println(getName() + " woke up after " + sleepTime + " nanoseconds.");
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
        }
    }
}

public class ThreadSleepExample {
    public static void main(String[] args) {
        // Create a new thread with some example data
        UserThreadPriority thread = new UserThreadPriority("HelloWorld", 'X');

        // Set the name of the thread
        thread.setName("ThreadA");

        // Start the thread
        thread.start();
    }
}

