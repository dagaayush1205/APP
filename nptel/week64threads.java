import java.util.*;
class Execute{
   void print(int n){
    for(int i = 0 ; i<=5 ; i++)
    {
      System.out.println(i*n);
      try {
        Thread.sleep(400);
      }
      catch(Exception e){
        System.out.println(e);
      }
    }
  }
}
class Thread1 extends Thread{
  Execute t;
  Thread1(Execute t){
    this.t = t;
  }
  public void run(){
    t.print(5);
  }
}
class Thread2 extends Thread{
  Execute t;
  Thread2(Execute t){
    this.t = t;
  }
  public void run(){
    t.print(100);
  }
}
public class week64threads{
  public static void main(String args[]){
    Execute obj = new Execute();
    Thread1 t1 = new Thread1(obj);
    Thread2 t2 = new Thread2(obj);
    t1.start();
    t2.start();
  }
}
