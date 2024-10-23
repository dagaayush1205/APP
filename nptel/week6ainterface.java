import java.util.*;
interface Number{
  int spr(int num);
}
class A implements Number{
  public int spr(int num){
    return num*num;
  }
}
public class week6ainterface{
  public static void main(String args[])
  {
    A obj = new A();
    int a = obj.spr(5);
    System.out.println(a);
  }
}
