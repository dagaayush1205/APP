import java.util.*;
public class threading extends Thread {
    public void run()
    {
      System.out.println("Thread is running");
    }
    public static void main(String args[])
    {
      threading obj = new threading();
      Thread th1 = new Thread(obj);
      th1.start();
    }
}
