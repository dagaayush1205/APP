import java.util.LinkedList;
import java.util.Queue;

class Printer {
    private Queue<PrintJob> jobQueue = new LinkedList<>();
    private int nextJobId = 1;

    // Method to add a print job to the queue
    public synchronized void submitJob(PrintJob job) {
        jobQueue.add(job);
        System.out.println("Job " + job.getJobId() + " submitted by " + job.getJobOwner());
        notifyAll();  // Notify the printer that a new job is available
    }

    // Method to process jobs in order
    public synchronized void processJobs() {
        while (true) {
            while (jobQueue.isEmpty() || jobQueue.peek().getJobId() != nextJobId) {
                try {
                    wait();  // Wait until there's a job to process and it is in order
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Process the next job in the queue
            PrintJob job = jobQueue.poll();
            System.out.println("Processing Job " + job.getJobId() + " submitted by " + job.getJobOwner());
            nextJobId++;
            
            // Simulate job processing time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("Job " + job.getJobId() + " completed.");
            notifyAll();
        }
    }
}

class PrintJob {
    private static int idCounter = 1;
    private final int jobId;
    private final String jobOwner;

    public PrintJob(String jobOwner) {
        this.jobId = idCounter++;
        this.jobOwner = jobOwner;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobOwner() {
        return jobOwner;
    }
}

public class PrinterSynchronization {
    public static void main(String[] args) {
        Printer printer = new Printer();

        // Start a thread for the printer to process jobs
        Thread printerThread = new Thread(() -> {
            printer.processJobs();
        });
        printerThread.start();

        // Simulate multiple users submitting jobs
        new Thread(() -> printer.submitJob(new PrintJob("User1"))).start();
        new Thread(() -> printer.submitJob(new PrintJob("User2"))).start();
        new Thread(() -> printer.submitJob(new PrintJob("User3"))).start();
        new Thread(() -> printer.submitJob(new PrintJob("User4"))).start();
    }
}

