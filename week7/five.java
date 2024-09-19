class ProcessThread extends Thread {
    public ProcessThread(String name) {
        // Set the name of the thread
        setName(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running with priority " + getPriority());
        // Simulate some work by sleeping for a short period
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
        }
        System.out.println(getName() + " has finished.");
    }
}

public class five {
    public static void main(String[] args) {
        // Create 5 threads (representing 5 processes)
        ProcessThread thread1 = new ProcessThread("Process1");
        ProcessThread thread2 = new ProcessThread("Process2");
        ProcessThread thread3 = new ProcessThread("Process3");
        ProcessThread thread4 = new ProcessThread("Process4");
        ProcessThread thread5 = new ProcessThread("Process5");

        // Set different priorities for the threads
        thread1.setPriority(Thread.MIN_PRIORITY);  // Priority 1
        thread2.setPriority(3);                    // Priority 3
        thread3.setPriority(Thread.NORM_PRIORITY); // Priority 5 (default)
        thread4.setPriority(7);                    // Priority 7
        thread5.setPriority(Thread.MAX_PRIORITY);  // Priority 10

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

